import React, {Component} from 'react';
//import {withRouter} from 'react-router-dom';
import PropTypes from 'prop-types';
import '../App.css';
//import TextField from 'material-ui/TextField';
//aimport * as API from '../api/API';
import sharedFolderIcon from '../sharedDir.png';


class NewSharedFolder extends Component {
    static propTypes = {

        createSharedFolder: PropTypes.func.isRequired
        //images: PropTypes.array.isRequired
    };

    constructor() {
        super();
        this.state = {
            sharedFolderName: '',
            userlist: ''
        }
    }

    render() {
        return (

          <div style={{marginLeft:50}}>
              <img alt="myImg" src={sharedFolderIcon}/>
              <input style={{marginLeft:20}} placeholder={'Shared Folder Name'} value={this.state.sharedFolderName} onChange={(event) => {
                  this.setState({
                      sharedFolderName: event.target.value
                  });
              }}/>
              <input style={{marginLeft:20,width:300}}placeholder={'emails seperated by , '} value={this.state.userlist} onChange={(event) => {
                  this.setState({
                      userlist: event.target.value
                  });
              }}/>
              <button style={{marginLeft:20}}className="btn btn-primary navuploadButton"
                      type="submit"
                      onClick={this.props.createSharedFolder.bind(this, JSON.stringify(this.state))}>
                  Create
              </button>
              <br/><div className="myStyle-main4"><hr/></div>

          </div>

    );
    }
    }

    export default NewSharedFolder;
