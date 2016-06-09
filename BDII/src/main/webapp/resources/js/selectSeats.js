//DATA

//array of sector objects
// sector describing object e.g.:
// {
//   name: 'name',
//   rowsNumber: 3,
//   columnsNumber: 5
// }
sectorsArray = [];
//   {
//     name:'Parter',
//     rowsNumber: 5,
//     columnsNumber: 8
//   },
//   {
//     name: 'Balkon',
//     rowsNumber: 4,
//     columnsNumber: 10
//   }
// ];

// seat state are kept as object as follows:
// {
//   nameOfSector1: [array of seat numbers],
//   nameOfSector2: [array of seat numbers],
//   ...
// }
occupiedSeats = {};
//   Parter:[2,4,14,15,22],
//   Balkon:[35,36,37]
// };
selectedSeats = {};

//LOGIC

//checks if array contains object
function arrayContains(array, object) {
  for(var i = 0; i < array.length; i++) {
    if(array[i] == object) {
      return true;
    }
  }
  return false;
}

function selectSeat(tableId, seatNumber) {
  var seatId = tableId + seatNumber;
  seatNumber = Number(seatNumber);//conversion from String to number
  var occupied = arrayContains(occupiedSeats[tableId], seatNumber);
  if(!occupied) {
    var td = document.getElementById(seatId);
    var selected = arrayContains(selectedSeats[tableId], seatNumber);
    if(!selected) {
      selectedSeats[tableId].push(seatNumber);
      td.style.background = "#92d36e";
    }
    else {
      var index = selectedSeats[tableId].indexOf(seatNumber);
      selectedSeats[tableId].splice(index, 1);
      td.style.background = "#ffffff";
    }
    var selectedSeatsParagraph = document.getElementById(tableId + "SelectedSeats");
    if(selectedSeats[tableId].length > 0) {
      selectedSeats[tableId].sort(function(a,b){return a-b});
      selectedSeatsParagraph.innerHTML = selectedSeats[tableId].toString();
    }
    else {
      selectedSeatsParagraph.innerHTML = '-';
    }
  }
}

function fillSectorSeatsTable(tableId, rowsNumber, columnsNumber) {
  var table = document.getElementById(tableId);
  var seatNumber = 0;
  for(var i = 0; i < rowsNumber; i++) {
    var row = table.insertRow();
    for(var j = 0; j < columnsNumber; j++) {
      seatNumber++;
      var td = row.insertCell();
      td.id = tableId + seatNumber;
      td.appendChild(document.createTextNode(seatNumber));
      td.className += " seat";
      var occupied = arrayContains(occupiedSeats[tableId], seatNumber);
      if(occupied) {
        td.className += " occupied";
      }
    }
  }
  // make cells clickable
  table.addEventListener("click", function(e) {
        if(e.target && e.target.nodeName == "TD") {
            selectSeat(table.id, e.target.textContent);
        }
  })
}

//additionaly draws sector name and field for seats in selected seats section
function createSector(name, rowsNumber, columnsNumber) {
  //add key with empty list to selectedSeats object
  selectedSeats[name] = [];
  var container = document.getElementById('sectors');
  //create header
  var headerDiv = document.createElement('DIV');
  headerDiv.className += ' center-content';
  var header = document.createElement('H2');
  header.innerHTML = 'Sektor: ' + name;
  headerDiv.appendChild(header);
  container.appendChild(headerDiv);
  //create table
  var sectorTable = document.createElement("TABLE");
  sectorTable.id = name;
  sectorTable.className += " select-seats center-align";
  container.appendChild(sectorTable);
  fillSectorSeatsTable(name, rowsNumber, columnsNumber);
  //fill selected seats section
  container = document.getElementById('selected-seats');
  var sectorNameParagraph = document.createElement('P');
  sectorNameParagraph.innerHTML = 'Sektor: ' + name;
  var sectorSelectedSeatsParagraph  = document.createElement('P');
  sectorSelectedSeatsParagraph.id = name + "SelectedSeats";
  sectorSelectedSeatsParagraph.innerHTML = '-';
  container.appendChild(sectorNameParagraph);
  container.appendChild(sectorSelectedSeatsParagraph);
}

function createSectors() {
  for (var i = 0; i < sectorsArray.length; i++) {
    createSector(sectorsArray[i].name, sectorsArray[i].rowsNumber, sectorsArray[i].columnsNumber);
  }
}


function initializePage(realizationId) {


  $.getJSON("/roomInfo?realizationId=" + realizationId, function(result){
    console.log("callback");
    for (var i = 0; i < result.length; i++) {
      var sector = {
        name: result[i].name.toString(),
        rowsNumber: result[i].rowsNumber,
        columnsNumber: result[i].columnsNumber
      };
      sectorsArray.push(sector);
      occupiedSeats[result[i].name.toString()] = result[i].occupiedSeats;
    }
    createSectors();
  });
  console.log("init");
}
