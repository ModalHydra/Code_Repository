import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerAbout(){

    return(
        <div>
            <style>
                {`
                    #aboutTitle{
                        width: 85%;
                        font-size: 90pt;
                        text-align: center;
                        float: right;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "aboutTitle">
                    About
             </div>
             
        </div>
    );


}