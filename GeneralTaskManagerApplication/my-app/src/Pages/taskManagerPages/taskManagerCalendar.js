import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerCalendar(){

    return(
        <div>
            <style>
                {`
                    #calendarTitle{
                        width: 85%;
                        font-size: 90pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "calendarTitle">
                    Calendar
             </div>
             
        </div>
    );


}