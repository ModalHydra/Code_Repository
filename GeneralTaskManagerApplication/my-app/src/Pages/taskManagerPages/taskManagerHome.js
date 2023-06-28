import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerHomer(){

    return(
        <div>
            <style>
                {`
                    #homeTitle{
                        width: 85%;
                        font-size: 90pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "homeTitle">
                    To Do...
             </div>
             
        </div>
    );


}