import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerEditor(){

    return(
        <div>
            <style>
                {`
                    #EditorTitle{
                        width: 85%;
                        font-size: 90pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "EditorTitle">
                    Manage Tasks
             </div>
             
        </div>
    );


}