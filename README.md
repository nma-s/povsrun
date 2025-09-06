# Run Club API

A simple Spring Boot REST API to manage run events, routes, and runners for a run club.
You can create events, attach existing routes and participants, and query routes by distance, starting point and via routes and also query events by the month.

## Tech Stack

1. Java 17
2. Spring Boot 3.5.4
3. MySQL 
4. Maven


## Project Structure

**RunEvent** – an event on a specific date; can have many routes and many participants. Derived field month is computed from date and returned in JSON.

**Route** – a route with distanceInKm, startingPoint, and viaRoute points (bridges, landmarks, etc.).

**Runner** – a participant with firstName, lastName, and gender.

#### Enitity Relationships:

**Many-to-Many**

1. RunEvent &rarr; Route
2. RunEvent &rarr; Runner

## Getting Started

1. Clone the repository:
```
git clone https://github.com/MatiasCarabella/formula1-driver-API.git
cd formula1-driver-API
```


## API Endpoints

Base paths:
 - **Run Events:** `/api/runevents`
 - **Routes:** `/api/routes`
 - **Runners:** `/api/runners`

### Runners

| Method | Endpoint | Description | Params/Body |
|:---:| --- | ---- | ----- |
| **GET** | `/api/runners`| Retrieve a list of runners |  |
| **GET** | `/api/runners/{id}` | Retrieve a specific runner by its ID |  |
| **POST** | `/api/runners` | Create a new runner| `{ "firstName":"...", "lastName":"...", "gender":"FEMALE/MALE/OTHER" }` |
| **PUT** | `/api/runners/{id}` | Update an existing runner by ID | `{ "firstName":"...", "lastName":"...", "gender":"FEMALE/MALE/OTHER" }` |
| **DELETE** | `/api/runners/{id}` | Delete an runner by ID |  |

### Routes

| Method | Endpoint | Description | Params/Body |
|:---:|---|---|----|
| **GET**| `/api/routes` | Retrieve a list all routes |  |
| **GET** | `/api/routes/{routeId}` | Retrieve a route by ID | |
| **POST**| `/api/routes` | Create a new route | `{"name": "...", "distanceInKm": "...", "startingPoint": "...", "viaRoute": ["..."] }` |
| **PUT** | `/api/routes/{id}` | Update an existing route by ID | `{"name": "...", "distanceInKm": "...", "startingPoint": "...", "viaRoute": ["..."] }`|
| **GET** | `/api/routes/search?startingPoint=...`| Search by starting point (case-insensitive) | `startingPoint`|
| **GET** | `/api/routes/search/via?viaRoute=...` | Search by via-point (case-insensitive) | `viaRoute`|

### Run Events
| Method | Endpoint | Description | Params/Body |
|:---:|---|---|----|
| **GET** | `/api/runevents` | Retrieve a list all run events |    |
| **GET** | `/api/runevents/{id}` | Retrieve a specific run event by ID |  |
| **POST** | `/api/runevents` | Create a new run event |`{"name": "....", "date": "YYYY-MM-DD" }`|
| **PUT** | `/api/runevents/{id}` | Update an existing event by ID |`{"name": "....", "date": "YYYY-MM-DD" }`|
| **PUT**| `/api/runevents/{eventId}/routes/{routeId}` | Attach existing route to event  |  |
| **PUT** | `/api/runevents/{eventId}/runners/{runnerId}` | Attach existing runner to event | |
| **GET** | `/api/runevents/by-month?month=9` | Lists all events in a given month | `month=1-12` |

