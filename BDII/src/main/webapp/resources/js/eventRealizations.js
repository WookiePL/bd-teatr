//DATA
//events is an array of event objects
events = [
  {
      name: 'Romeo i Julia',
      type: 'Dramat',
      date: '23-05-2016',
      hour: '17:00',
      room: '4',
      building: 'ul.Jagiellońska 12'
  },
  {
      name: 'Kasztanek',
      type: 'Komedia',
      date: '12-05-2016',
      hour: '20:00',
      room: '3',
      building: 'ul.Jagiellońska 12'
  },
  {
      name: 'Sztuka',
      type: 'Dramat',
      date: '28-05-2016',
      hour: '16:00',
      room: '1',
      building: 'ul.Moja 3'
  }
]

//LOGIC

function fillEventsTable() {
  var tbody = document.getElementById('eventsTableBody');
  for (var i = 0; i < events.length; i++) {
    var row = tbody.insertRow();
    var td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].name));
    td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].type));
    td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].date));
    td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].hour));
    td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].room));
    td = row.insertCell();
    td.appendChild(document.createTextNode(events[i].building));
    td = row.insertCell(); //for actions
    //first action icon
    var a = document.createElement("A");
    a.href = "selectSeats.html";
    var img = new Image();
    img.src = "../assets/images/seat.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Wybierz miejsca");
    a.appendChild(img);
    td.appendChild(a);
    //second action icon
    a = document.createElement("A");
    a.href = "eventReservations.html";
    img = new Image();
    img.src = "../assets/images/reservation.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Zobacz rezerwacje");
    a.appendChild(img);
    td.appendChild(a);
  }
}
