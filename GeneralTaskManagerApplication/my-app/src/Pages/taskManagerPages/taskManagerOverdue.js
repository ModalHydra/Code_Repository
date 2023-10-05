import SideBar from "../../Components/taskManagerComponents/SideBar";
import TaskList from "../../Components/taskManagerComponents/TaskList";
//import Cookies from 'js-cookie';

export default function TaskManagerOverdue(){

    

    return(
        <div>
            <style>
                {`
                    #overdueTitle{
                        width: 85%;
                        font-size: 70pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             <div>
                <SideBar/>
                <TaskList/>
             </div>

             
        </div>
    );


}