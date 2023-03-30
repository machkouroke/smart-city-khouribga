const registerForm = document.getElementById('register');
const loader = document.getElementById('loader');
const name = document.getElementById('name');
const surname = document.getElementById('surname');
const mail = document.getElementById('mail');
const birthDate = document.getElementById('birthDate');
const dateOfArrivalInMorocco = document.getElementById('dateOfArrivalInMorocco');
const school = document.getElementById('school');
const nationality = document.getElementById("nationality")
const sucessMessage = document.getElementById('sucess');
const amciIdentifier = document.getElementById('amciIdentifier');

function displayLoading() {
    loader.classList.add("display");
    // to stop loading after some time
    setTimeout(() => {
        loader.classList.remove("display");
    }, 5000);
}

function hideLoading() {
    loader.classList.remove("display");
}

function disableForm() {
    for (const element of registerForm) {
        element.disabled = true;
    }
}

if (localStorage.getItem('registered') === 'true') {
    const userRegistered =  JSON.parse(localStorage.getItem('user'));
    for (const element of Object.keys(userRegistered)) {
        console.log(element);
        document.getElementById(element).value = userRegistered[element];
    }
    sucessMessage.classList.remove('d-none');
    sucessMessage.innerHTML = "Vos informations ont été envoyé avec succès";
    disableForm();
} else {
    registerForm.addEventListener('submit', (e) => {
        e.preventDefault();
        displayLoading();

        fetch('https://cesam-backend.herokuapp.com/Users?type=cesamien', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "name": name.value,
                "surname": surname.value,
                "mail": mail.value,
                "notification": [],
                "password": `${name.value}${surname.value}`,
                "contribution": {},
                "nationality": nationality.value,
                "birthDate": `${birthDate.value}T00:00:00.000Z`,
                "dateOfArrivalInMorocco": `${dateOfArrivalInMorocco.value}T00:00:00.000Z`,
                "school": school.value,
                "amciIdentifier": amciIdentifier.value
            })
        }).then((response) => {
            loader.classList.remove('display');
            if (response.ok) {
                return response.json();
            } else if (response.status === 401) {
                throw new Error(`L'utilisateur avec le mail "${mail.value}" existe déjà`);
            } else {
                throw new Error('Une erreur est survenue');
            }
        }).then((data) => {
            hideLoading()

            const failureMessage = document.getElementById('failure');
            failureMessage.classList.contains("d-none") || failureMessage.classList.add("d-none");
            sucessMessage.classList.remove('d-none');
            sucessMessage.innerHTML = "Vos informations ont été envoyé avec succès";
            disableForm();
            localStorage.setItem('registered', 'true');
            localStorage.setItem('user', JSON.stringify({
                "name": name.value,
                "surname": surname.value,
                "mail": mail.value,
                "birthDate": birthDate.value,
                "school": school.value,
                "nationality": nationality.value
            }));
        }).catch((error) => {
            hideLoading()

            const failureMessage = document.getElementById('failure');
            failureMessage.classList.remove('d-none');
            console.log(error);
            failureMessage.innerHTML = `${error}`;
        })

    })
}
