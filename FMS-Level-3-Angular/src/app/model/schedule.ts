import { Airport } from './airport.component';

export class Schedule {
    scheduleId: number;
    srcAirport: Airport;
    dstnAirport: Airport;
    deptDateTime: string;
    arrDateTime: string;
}
