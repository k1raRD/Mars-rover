# Mars-rover

This project consists on a backend **REST API** for Mars Rover Kata

---

### Steps to Setup

- **1. Clone the application.**

``` bash
git clone https://github.com/k1raRD/Mars-rover.git
```

- **2. Run the app using maven.**

```bash
mvn spring-boot:run
```

The app will start running at [http://localhost:8080](http://localhost:8080/)

---

### Endpoints

**Rover**

| Method | URL                        | Description                                 | Valid Request Body                                                                  |
| ------ |----------------------------|---------------------------------------------|-------------------------------------------------------------------------------------|
| GET    | /api/mars/rover            | Retrieved all the map and rover infotmacion |                                                                                     |
| POST   | /api/mars/rover/{commands} | gives commands to the rover to move         | 'L' Turn the rover left<br/>'R' Turn the rover right<br/>'M' move forward the rover |