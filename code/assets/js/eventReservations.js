//DATA

//reservations is an array of reservation objects
reservations = [
  {
    name: 'Jan Kowalski',
    email: 'janusz@onet.pl',
    phone: '123456789',
    created: '11-04-2016',
    rejected: '-',
    sector: 'Parter',
    seats: [2,4]
  },
  {
    name: 'Wilhelm Byk',
    email: 'wb@gmail.com',
    phone: '987654321',
    created: '22-03-2016',
    rejected: '-',
    sector: 'Parter',
    seats: [14,15,22]
  },
  {
    name: 'Mieszko Pierwszy',
    email: 'king@polska.pl',
    phone: '000000000',
    created: '16-04-2016',
    rejected: '29-04-2016',
    sector: '-',
    seats: '-'
  }
]

//LOGIC

function fillEventReservationTable() {
  var tbody = document.getElementById('reservationsTableBody');
  for (var i = 0; i < reservations.length; i++) {
    var row = tbody.insertRow();
    var td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].name));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].email));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].phone));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].created));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].rejected));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].sector));
    td = row.insertCell();
    td.appendChild(document.createTextNode(reservations[i].seats));
    td = row.insertCell(); //for actions
    //first action icon
    var a = document.createElement("A");
    a.href = "#";
    var img = new Image();
    img.src = "../assets/images/confirm.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Sprzedaj bilet");
    a.appendChild(img);
    td.appendChild(a);
    //second action icon
    a = document.createElement("A");
    a.href = "#";
    img = new Image();
    img.src = "../assets/images/reject.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Anuluj rezerwację");
    a.appendChild(img);
    td.appendChild(a);
    //third action icon
    a = document.createElement("A");
    a.href = "#";
    img = new Image();
    img.src = "../assets/images/edit.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Edytuj rezerwację");
    a.appendChild(img);
    td.appendChild(a);
  }
}

function initializePage() {
  fillEventDescriptionTable();
  fillEventReservationTable();
}
