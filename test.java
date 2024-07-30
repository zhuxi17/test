logTxt.Text = "Sending request..." & vbCrLf

System.Net.ServicePointManager.SecurityProtocol = DirectCast(3072, System.Net.SecurityProtocolType)

Dim apiEndpoint As String = "https://api.openai.com/v1/images/generations"
Dim apiKey As String = ApiKeyTextBox.Text
Dim prompt As String = PromptTextBox.Text
Dim model As String = "dall-e-2"
Dim numberofimages As String = "1"
Dim imagesize As String = "512x512"

' Creation of HTTP request
Dim request As HttpWebRequest = WebRequest.Create(apiEndpoint)
request.Method = "POST"
request.ContentType = "application/json"
request.Headers.Add("Authorization", "Bearer " & apiKey)

' Creation of JSON request
Dim data As String = "{"
data += " ""model"": """ & model & ""","
data += " ""prompt"": """ & prompt & ""","
data += " ""n"": 1,"
data += " ""size"": """ & imagesize & """"
data += "}"
logTxt.Text += "Request grammar: " & data.ToString & vbCrLf
' Write body of request
Using streamWriter As New StreamWriter(request.GetRequestStream())
    streamWriter.Write(data)

End Using
