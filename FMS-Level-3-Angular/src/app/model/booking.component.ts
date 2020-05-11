import { ScheduledFlight } from "./scheduled-flight";
import { Passenger } from "./passenger.component";

export class Booking{

    bookingId:number;
    userId:number;
    bookingDate:any;
    ticketCost:number;
    passengerCount:number;
    bookingState:boolean;
    scheduleFlight:ScheduledFlight;
    passengerList:Passenger[];

}
