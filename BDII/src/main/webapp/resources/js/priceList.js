//DATA
//events is an array of event objects
events = [
  {
      name: 'Cennik',
      from: '2016-01-01',
      to: '2016-03-31'
  },
  {
      name: 'Cennik2',
      from: '2016-04-01',
      to: '2016-12-31'
  },
  {
      name: 'Promocja',
      from: '2016-07-01',
      to: '2016-07-07'
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
    td.appendChild(document.createTextNode(events[i].from));
    td = row.insertCell(); //for actions
    td.appendChild(document.createTextNode(events[i].to));
    td = row.insertCell(); //for actions
    //first action icon
    var a = document.createElement("A");
    a.href = "selectSeats.html";
    var img = new Image();
    img.src = "../assets/images/reject.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Usuń");
    a.appendChild(img);
    td.appendChild(a);
    //second action icon
    a = document.createElement("A");
    a.href = "eventReservations.html";
    img = new Image();
    img.src = "../assets/images/edit.png";
    img.className += " action-icon";
    img.setAttribute("data-toggle", "tooltip");
    img.setAttribute("data-placement", "bottom");
    img.setAttribute("title", "Edytuj");
    a.appendChild(img);
    td.appendChild(a);
  }
}
