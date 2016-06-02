//DATA
//event describing object
eventObject = {
  name: 'Romeo i Julia',
  date: '23-05-2016',
  hour: '17:00',
  room: '4',
  building: 'ul.Jagiellońska 12'
}

//LOGIC

//display tooltip
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
});

function fillEventDescriptionTable() {
  var element = document.getElementById('eventName');
  element.innerHTML = eventObject.name;
  element = document.getElementById('eventDate');
  element.innerHTML = eventObject.date;
  element = document.getElementById('eventHour');
  element.innerHTML = eventObject.hour;
  element = document.getElementById('eventRoom');
  element.innerHTML = eventObject.room;
  element = document.getElementById('eventBuilding');
  element.innerHTML = eventObject.building;
}
