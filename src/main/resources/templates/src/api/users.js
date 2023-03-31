const BASE_URL = "https://cesam-backend.herokuapp.com"

function login(mail, password) {
    const option = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            mail: mail,
            password: password
        })
    }
    return fetch(`${BASE_URL}/auth/login`,
        option)
        .then(response => {
            return response.json()
        })
}