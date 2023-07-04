import SideBar from "../../Components/taskManagerComponents/SideBar";
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
           
             
             <SideBar/>
             <h1 id = "overdueTitle">
                    Overdue
             </h1>
             
        </div>
    );


}