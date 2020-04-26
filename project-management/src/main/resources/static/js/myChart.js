function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}

var ticketDataStr = decodeHtml(ticketData);
var ticketJsonArray = JSON.parse(ticketDataStr);

var arrayLength = ticketJsonArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
	numericData[i] = ticketJsonArray[i].value;
	labelData[i] = ticketJsonArray[i].label;
}


// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#7a5195', '#ef5675', '#ffa600'],
            borderColor: '#c5c5c5',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: false,
    		text: 'Ticket Statuses'
    	}
    }
});


///////////////////////////////////////////////////////////////////////////////

var ticketDataStr2 = decodeHtml(ticketPriorityData);
var ticketJsonArray2 = JSON.parse(ticketDataStr2);

var arrayLength2 = ticketJsonArray2.length;
var numericData2 = [];
var labelData2 = [];

for (var i = 0; i < arrayLength2; i++) {
	numericData2[i] = ticketJsonArray2[i].value;
	labelData2[i] = ticketJsonArray2[i].label;
}



new Chart(document.getElementById("myPieChart2"), {
    type: 'pie',
    data: {
        labels: labelData2,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
            borderColor: '#c5c5c5',
            data: numericData2
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: false,
    		text: 'Ticket Priority'
    	}
    }
});

///////////////////////////////////////////////////////////////////////////////////////

var ticketDataStr3 = decodeHtml(ticketTypeData);
var ticketJsonArray3 = JSON.parse(ticketDataStr3);

var arrayLength3 = ticketJsonArray3.length;
var numericData3 = [];
var labelData3 = [];

for (var i = 0; i < arrayLength3; i++) {
	numericData3[i] = ticketJsonArray3[i].value;
	labelData3[i] = ticketJsonArray3[i].label;
}

new Chart(document.getElementById("myPieChart3"), {
    type: 'bar',
    data: {
        labels: labelData3,
        datasets: [{
            label: 'Ticket Type',
            backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
            borderColor: '#c5c5c5',
            data: numericData3,
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: false,
    		text: 'Ticket Type'
    	},
    	scales: {
            yAxes:[{
                ticks: {
                    min:0
                }
            }],
        }
    }
});

//////////////////////////////////////////////////////////////////////////////////


new Chart(document.getElementById("myPieChart4"), {
    type: 'bar',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May'],
        datasets: [{
            label: '2020',
            backgroundColor: ['#003f5c', '#58508d', '#bc5090', '#ff6361', '#ffa600'],
            borderColor: '#c5c5c5',
            borderColor: '#c5c5c5',
            data: [3, 10, 5, 12, 1]
        }]
    },

    // Configuration options go here
    options: {
    	scales: {
            yAxes:[{
                ticks: {
                    min:0
                }
            }],
        }
    }
});