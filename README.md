# mars-rover

Mars rover API use basic auth security, see the application log to get the default password

For instance:
user:ea09513e-6729-4ed2-85ad-2053bdbf8a9d

The follow actions are allowed:

DELETE /marsRover/navigate : Stop Mars Rover

PUT /marsRover/navigate : Move Mars Rover to given location  
``` [json]
{
    "latidude": 283.99,
    "longitude": 238.11
}
```

GET /marsRover/navigateHistory : List Mars Rover locations history 

DELETE /marsRover/navigateHistory : Delete Mars Rover locations history 

POST /marsRover/message : Send a new message
