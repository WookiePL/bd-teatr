//DATA

// selected seats is list of objects as follows
// {
//   sector: 'nameOfSector',
//   seats: [array of seat numbers]
// }
selectedSeats = [
  {
    sector: 'Parter',
    seats: [12,13,14]
  },
  {
    sector: 'Balkon',
    seats: [2,6]
  }
];

client = {
  name: 'Jan',
  surname: 'Kowalski',
  email: 'janusz@onet.pl',
  phone: '123456789',
}
//LOGIC

function fillSelectedSeatsField() {
  var p = document.getElementById('seatsList');
  var seatsMessage = '';
  for (var i = 0; i < selectedSeats.length; i++) {
    seatsMessage += selectedSeats[i].sector + ':  ' + selectedSeats[i].seats + '<br>';
  }
  p.innerHTML = seatsMessage;
}

function fillFormWithClientData() {
  document.getElementById('clientName').value = client.name;
  document.getElementById('clientSurname').value = client.surname;
  document.getElementById('clientEmail').value = client.email;
  document.getElementById('clientPhone').value = client.phone;
}

function initializePage() {
  fillEventDescriptionTable();
  fillFormWithClientData();
  fillSelectedSeatsField();
}
