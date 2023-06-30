import SideBar from "../../Components/taskManagerComponents/SideBar";
import Task from "../../Components/taskManagerComponents/Task";

export default function TaskManagerHomer(){

    return(
        <div>
            <style>
                {`
                    #homeTitle{
                        width: 85%;
                        font-size: 70pt;
                        text-align: center;
                        float: right;
                    }

                    #taskHolder{
                        background: #a0a096;
                        width: 70%;
                        height: 60vh;
                        float: right;
                        text-align: center;
                        position: absolute;
                        top: 25%;
                        left: 22%;
                    }

                    #taskList{
                        
                    }

                    li.task{
                        margin: 5px;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "homeTitle">
                    To Do...
                    <br/>
             </div>
             <div id = "taskHolder">
                <ol id = "taskList">
                    <li class = "task">
                        <Task/>
                    </li>
                    <li class = "task">
                        <Task/>
                    </li>
                    <li class = "task">
                        <Task/>
                    </li>
                    <li class = "task">
                        <Task/>
                    </li>
                    <li class = "task">
                        <Task/>
                    </li>
                </ol>
             </div>
            
             
        </div>
    );


}