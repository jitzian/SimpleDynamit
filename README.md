# DYNAMIT: MOBILE DEVELOPER CODE PROMPT

Write a native app (iOS or Android) that consumes data from from the open air quality API
( https://docs.openaq.org/ ) and displays it to the screen.
Display a listing of the city names and number of measurements that are available for that city. Do
not show any cities that have less than 10,000 measurements. The listing should be sorted
descending by number of measurements. The app should use the most efficient way possible to
filter and sort the data.
Along with a display for the list, a user should be able to tap one of the locations and open a
detail view that includes additional information about the location/measurement.
Additionally, the app should be able to handle connectivity issues gracefully

## Getting Started

Clone project from: https://github.com/jitzian/SimpleIAmBored.git

### Prerequisites

Git previously installed.

Install nodeJS: Follow this link http://blog.teamtreehouse.com/install-node-js-npm-mac
Create file as server.js and save it with this code


var unirest = require('unirest');
var http = require('http')
var auth = require('basic-auth')
var request = require('request')

// Create server
var server = http.createServer(function (req, res) {
  var credentials = auth(req)

  if (!credentials || credentials.name !== 'user' || credentials.pass !== 'password') {
    res.statusCode = 401
    res.error = 'Unauthorized'
    res.message = "Bad username or password"
    console.log(res)
    res.end('{"statusCode": "401", "error": "Unauthorized", "message": "Bad user name or password", "attributes": { "error": "Bad username or password"}}')
  } else {
    // console.log(res)    // res.end('Access granted')
    res.end('{"statusCode": "200"}')

  }
})

server.listen(3000)
--
### Screenshots
![alt text](/screenshots/loginScreen.png "Login screen")
![alt text](/screenshots/welcomeScreen.png "Welcome screen")
![alt text](/screenshots/navigationScreen.png "Navigation screen")
![alt text](/screenshots/mainScreen.png "Main screen")
![alt text](/screenshots/detailScreen.png "Detail screen")
![alt text](/screenshots/offlineScreen.png "Offline screen")

### Running

Run nodeJS server (npm start)

After cloning and launching the app, introduce the following credentials
uss: user
password: password

```
user: user
password: password
```


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Coffee

