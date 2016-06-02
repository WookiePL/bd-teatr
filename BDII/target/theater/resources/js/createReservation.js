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

//LOGIC

function fillSelectedSeatsField() {
  var p = document.getElementById('seatsList');
  var seatsMessage = '';
  for (var i = 0; i < selectedSeats.length; i++) {
    seatsMessage += selectedSeats[i].sector + ':  ' + selectedSeats[i].seats + '<br>';
  }
  p.innerHTML = seatsMessage;
}

function initializePage() {
  fillEventDescriptionTable();
  fillSelectedSeatsField();
}
