export default function TaskList(){

    return(
        <div className="container my-5">
            <div className="jumbotron py-3">
                <div className="row">
                    <div className="col-md-2">
                        <button className="btn btn-success m-3">New Task</button>
                    </div>
                    <div className="col-md-10">
                        <h2 className="diaplay-4">
                            Task List
                        </h2>
                    </div>
                </div>
                <form>
                    <div className="form-group">
                        <input type="text" className="form-control" placeholder="Task Name"/>
                    </div>
                    <div className="form-group">
                        <textarea type="text" className="form-control" placeholder="Task Description"></textarea>
                    </div>
                    <div>
                        <button type="submit" className="btn btn-primary">Submit Task</button>
                    </div>
                </form>
            </div>
        </div>

    );
}