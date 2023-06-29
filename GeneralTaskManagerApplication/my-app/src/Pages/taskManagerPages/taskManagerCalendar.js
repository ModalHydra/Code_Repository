import SideBar from "../../Components/taskManagerComponents/SideBar";
import Calendar from "../../Components/taskManagerComponents/Calendar";

export default function TaskManagerCalendar(){

    return(
        <div>
            <style>
                {`
                    #calendarTitle{
                        width: 84%;
                        font-size: 70pt;
                        text-align: center;
                        float: right;
                    }

                    #calendarBody{
                        width: 84%;
                        float: right;
                        height: 80vh;
                        
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <h1 id = "calendarTitle">
                        Calendar
            </h1>
             <div id = "calendarBody">
                
             
                <Calendar/>
             </div>
             
        </div>
    );


}