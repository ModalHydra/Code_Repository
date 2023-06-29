import {useState} from 'react';
import Cal from 'react-calendar'; 
import '../../Styles/taskManagerStyles/calendarStyle.css'

export default function Calendar(){
    const [date, setDate] = useState(new Date())

    return(
        <>
            

            <div id = "calendarHolder">
                <Cal onChange={setDate} value={date}/>



            </div>
        
        </>
    );
}