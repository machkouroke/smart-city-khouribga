let countryList = [
    "Bénin",
    "Burkina-Faso",
    "Cameroun",
    "Comorres",
    "Côte d'ivoire",
    "Djibouti",
    "Gabon",
    "Guinée Conakry",
    "Guinée Bissau",
    "Libéria",
    "Mali",
    "Niger",
    "République Démocratique du Congo",
    "Tchad",
    "Togo"
]
const countrySelect = document.getElementById('nationality')
for (let country of countryList) {
    let option = document.createElement('option')
    option.value = country
    option.innerHTML = country
    countrySelect.appendChild(option)
}
