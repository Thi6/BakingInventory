const ipAddress = "34.65.43.71:8888";

//ip address for local host
// const ipAddress = "localhost:8080";

const makeRequest = (method, url, body) => {

    return new Promise((res, rej) => {
        const req = new XMLHttpRequest();

        req.onload = () => {
            if (req.status >= 200 && req.status <= 299) {
                res(req);
            } else {
                const reason = new Error("Rejected");
                rej(reason);
            }

        }
        req.open(method, url);
        req.send(body);
    }

    );
}