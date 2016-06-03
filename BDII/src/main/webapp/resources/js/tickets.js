// DATA
tickets = [
  {
    number: 12341,
    name: 'Romeo i Julia',
    date: '23-05-2016',
    hour: '17:00',
    room: '4',
    building: 'ul.Jagiellońska 12',
    sector: 'Parter',
    seat: 5
  },
  {
    number: 12342,
    name: 'Romeo i Julia',
    date: '23-05-2016',
    hour: '17:00',
    room: '4',
    building: 'ul.Jagiellońska 12',
    sector: 'Parter',
    seat: 6
  }
];

prices = [
  {
    name: 'podstawowa',
    price: 52.00
  },
  {
    name: 'student',
    price: 26.00
  },
  {
    name: 'emeryt',
    price: 30.00
  }
];

var sum;
// LOGIC

function createTicket(ticket, ticketIndex) {
  var div = document.getElementById('tickets');
  var table = document.createElement('TABLE');
  table.className = "table table-striped event-info center-align ticket";
  var row = table.insertRow();
  var td = row.insertCell();
  td.innerHTML = "Numer";
  td = row.insertCell();
  td.innerHTML = ticket.number;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Wydarzenie";
  td = row.insertCell();
  td.innerHTML = ticket.name;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Data";
  td = row.insertCell();
  td.innerHTML = ticket.date;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Godzina";
  td = row.insertCell();
  td.innerHTML = ticket.hour;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Budynek";
  td = row.insertCell();
  td.innerHTML = ticket.building;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Sala";
  td = row.insertCell();
  td.innerHTML = ticket.room;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Sektor";
  td = row.insertCell();
  td.innerHTML = ticket.sector;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Miejsce";
  td = row.insertCell();
  td.innerHTML = ticket.seat;

  row = table.insertRow();
  td = row.insertCell();
  td.innerHTML = "Cena";
  td = row.insertCell();
  var select = document.createElement('SELECT');
  select.id = 'select' + ticketIndex;
  select.setAttribute('onchange', 'sumPrices()');
  for (var i = 0; i < prices.length; i++) {
    var option = document.createElement('OPTION');
    option.value = i;
    option.innerHTML = prices[i].name + ' - ' + prices[i].price + 'zł';
    select.appendChild(option);
  }
  td.appendChild(select);
  div.appendChild(table);
}

function initializePage() {
  var p = document.getElementById('count');
  p.innerHTML = 'Ilość: ' + tickets.length;
  for (var i = 0; i < tickets.length; i++) {
    createTicket(tickets[i], i);
  }
}

function sumPrices() {
  sum = 0;
  for (var i = 0; i < tickets.length; i++) {
    var select = document.getElementById('select' + i);
    var priceIndex = select.options[select.selectedIndex].value;
    sum += prices[priceIndex].price;
  }
  document.getElementById('sum').innerHTML = sum;
}
