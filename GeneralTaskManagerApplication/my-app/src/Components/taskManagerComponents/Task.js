export default function Task(){

    return(
        <>
            <style>
            {`
                #taskItem{

                    background: green;
                    width: 80%;
                    display: table-row;
                }

                .taskCell{
                    background: #FF8585;
                    width: 20%;
                    display: table-cell;
                    border: solid 1px;
                    margin: auto;
                }

                

                
                }
            
            `}
            </style>

            <div id = "taskItem">

                <div id = "taskDate" class = "taskCell">
                    date
                </div>
                <div id = "taskName" class = "taskCell">
                    task name
                </div>

                <div class = "taskCell">
                    <button id = "confirmButton">
                        confirm
                    </button>

                </div>

                <div class = "taskCell">
                    <button id = "skipButton">
                        skip
                    </button>
                </div>

                <div class = "taskCell">
                    <button id = "deleteButton">
                        delete
                    </button>
                </div>


            </div>

        </>
    );
}