import React from "react";

class AddSeriesComponent extends React.Component {

    constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            status: ""
        };
    }

    handleSubmit(event) {
        event.preventDefault();
        var formData = new FormData(event.target);
        var data = {};
        
        for(var pair of formData.entries()) {
            data[pair[0]] = pair[1];
        }
        
        var self = this;

        fetch("http://localhost:8080/series/add", 
            {
                method: "POST",
                body: JSON.stringify(data),
                headers: {'Content-Type': 'application/json'}
            }
        )
        .then(function(response) {
            return response.text();
        })
        .then(function(response) {
            self.setState({
                status: response
            })
        });
    }

    render() {
        return (
            <div>
                <h1>Add series</h1>
                {
                    this.state.status && <div id="status">{this.state.status}</div>
                }
                <form action="" onSubmit={this.handleSubmit}>
                    <div>
                        <label>Id Series</label>
                        <input type="text" name="idSeries" />
                    </div>
                    <div>
                        <label>Name Series</label>
                        <input type="text" name="nameSeries" />
                    </div>
                    <div>
                        <label>NumberOfSeasons</label>
                        <input type="text" name="numberOfSeasons" />
                    </div>
                    <div>
                        <label>IDCategory</label>
                        <input type="text" name="idCategory" />
                    </div>
                    <div>
                        <label>IDPlatform</label>
                        <input type="text" name="idPlatform" />
                    </div>

                    <button type="submit" className="js_submit_btn">Trimite</button>
                </form>
            </div>
        );
    }
}

export default AddSeriesComponent;
