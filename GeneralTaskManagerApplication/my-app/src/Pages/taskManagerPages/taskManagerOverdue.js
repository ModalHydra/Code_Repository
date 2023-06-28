import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerOverdue(){

    return(
        <div>
            <style>
                {`
                    #overdueTitle{
                        width: 85%;
                        font-size: 90pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "overdueTitle">
                    Overdue
             </div>
             
        </div>
    );


}