//DATA
//events is an array of event objects
events = [
  {
      name: 'Romeo i Julia',
      type: 'Dramat',
      desc: 'Dramat Shakespeara'
  },
  {
      name: 'Kasztanek',
      type: 'Komedia',
      desc: 'Bardzo śmieszne'
  },
  {
      name: 'Sztuka',
      type: 'Dramat',
      desc: 'Dramat dla sztuki'
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
    td = row.insertCell(); //for actions
    td.appendChild(document.createTextNode(events[i].desc));
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
