angular.module('CalendarModel', []);
angular.module('CalendarModel').factory('Calendar', function(){
	
	var calendar = {};
	
	var create_event = function(list) {
//		{title: 'Event 1', description: 'Description 1', datetime: new Date(2015, 4, 15, 17)},
		var events = [];
		for(i in list){
			var event = {};
			event.title = list[i].name;
			event.description = list[i].desc;
			var date =  new Date(list[i].date);
			event.datetime = new Date(date.getFullYear(),date.getMonth()+1,date.getDate(),date.getHours() , date.getMinutes()); 
			events.push(event);
		}
		return events;
	}
	
	calendar.init = function(id,event_title,list) {
		var events = create_event(list);
		$(id).eCalendar({
			
			 weekDays: ['Do', 'Se', 'Te', 'Qu', 'Qu', 'Se', 'Sá'],
			        months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'September', 'October', 'Novembro', 'Dezembro'],
			        textArrows: {previous: '<', next: '>'},
			        eventTitle: event_title,
			        url: '',
			        events: events
			        });
	}
	return calendar;
	
});