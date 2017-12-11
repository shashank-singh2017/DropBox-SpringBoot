import React, {Component} from 'react';
import PropTypes from 'prop-types';
import '../App.css';
import LoginIcon from '../Drop_sec_icon.png';
import HeaderIcon from '../drop_fir_icon.png';

class Login extends Component {
    static propTypes = {
    handleSubmit: PropTypes.func.isRequired
    };

    state = {
        firstname: '',
        lastname: '',
        email: '',
        username: '',
        password: '',
        signIn: true

    };


    componentWillMount() {
        this.setState({
            username: '',
            password: ''
        });
    }



    renderSignIn() {

        return (
          <div>
            <div>
                <div className="row justify-content-md-center">
                    <span className="dropbox-2015 dropbox-logo-2015 container">
                    <header className="mast-head">

                        <nav className="mast-head__nav mast-head-nav">

                            <img src={HeaderIcon} />
                        </nav>
                        </header>
                    </span>
                </div>

                <br/><br/><br/><br/><br/><br/>


                <div className="row justify-content-md-center">
                    <div className="col-md-6">
                        <img src={LoginIcon}/>

                    </div>

                    <div className="col-md-4">

                        <form>
                            <div className="form-group">
                                <div className="login-register-header">Sign in</div>
                            </div>
                            <div className="login-register-switch">
                                <label className="login-register-switch-link"
                                       onClick={()=>{
                                        this.setState({
                                            signIn: false
                                        });
                                    }
                                    }
                                >
                                    or create an account
                                </label>


                            </div>

                            <br/>
                            <div className="form-group">
                                <hr/>
                                <input
                                    className="form-control"
                                    type="text"
                                    label="Username"
                                    placeholder="Email"
                                    value={this.state.username}
                                    onChange={(event) => {
                                        this.setState({
                                            username: event.target.value
                                        });
                                    }}
                                />
                            </div>

                            <div className="form-group">
                                <input
                                    className="form-control"
                                    type="password"
                                    label="password"
                                    placeholder="Password"
                                    value={this.state.password}
                                    onChange={(event) => {
                                        this.setState({
                                            password: event.target.value
                                        });
                                    }}
                                />
                            </div>
                            <div className="form-group">
                                <div className="row">
                                    <div className="col-md-6">
                                        <br/>
                                        <input className="checkbox_label" type="checkbox" id="cb" name="remember me"/>

                                        <label className="checkbox_label">Remember me</label>
                                    </div>
                                    <div className="col-md-6">
                                        <br/>
                                        <button
                                            className="Sign-in-button"
                                            type="button"
                                            onClick={this.props.handleSubmit.bind(this,(this.state))}>
                                            Sign in
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div className="footer" id="footer">
              <div className="container">

            <div className="row">
                <div className="box">
                    <h3> DropBox </h3>
                    <ul>
                        <li> <a href="#">About Us </a> </li>
                        <li> <a href="#">Pricing </a> </li>

                        <li> <a href="#">Business </a> </li>
                        <li> <a href="#">Enterprise </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> About Us </h3>
                    <ul>
                        <li> <a href="#"> DropBox Blog </a> </li>
                        <li> <a href="#"> About </a> </li>
                        <li> <a href="#"> Branding </a> </li>

                        <li> <a href="#"> Careers </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> Support </h3>
                    <ul>
                        <li> <a href="#"> Help Center </a> </li>
                        <li> <a href="#"> Contact Us </a> </li>
                        <li> <a href="#"> Copyright </a> </li>

                        <li> <a href="#"> Privacy and Terms </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> Community </h3>
                    <ul>
                        <li> <a href="#"> Referrals </a> </li>
                        <li> <a href="#"> Forum </a> </li>

                        <li> <a href="#"> Facebook </a> </li>
                        <li> <a href="#"> Developers </a> </li>
                    </ul>
                </div>

            </div>

            </div>
    </div>

        </div>
        );


    }

    renderSignUp() {


        return (
            <div>
            <div>
                <div className="row justify-content-md-center">
                    <span className="dropbox-2015 dropbox-logo-2015 container">
                    <header className="mast-head">
                        <nav className="mast-head__nav mast-head-nav">
                            <img src={HeaderIcon} />
                        </nav>
                        </header>
                    </span>
                </div>

                <br/><br/><br/><br/><br/><br/>


                <div className="row justify-content-md-left">
                    <div className="col-md-6">
                        <img src={LoginIcon}/>
                    </div>

                    <div className="col-md-4">

                        <form>
                            <div className="form-group">
                                <div className="login-register-header">Create an account</div>
                            </div>
                            <div className="login-register-switch">
                                <label onClick={()=>{
                                    this.setState({
                                        signIn: true
                                    });}}
                                       className="login-register-switch-link">
                                        or log in
                                </label>
                            </div>

                            <br/>
                            <hr/>
                            <div className="form-group">

                                <input
                                    className="form-control"
                                    type="text"
                                    label="FirstName"
                                    placeholder="First name"
                                    value={this.state.firstname}
                                    onChange={(event) => {
                                        this.setState({
                                            firstname: event.target.value
                                        });
                                    }}
                                />
                            </div>


                            <div className="form-group">

                                <input
                                    className="form-control"
                                    type="text"
                                    label="LastName"
                                    placeholder="Last name"
                                    value={this.state.lastname}
                                    onChange={(event) => {
                                        this.setState({
                                            lastname: event.target.value
                                        });
                                    }}
                                />
                            </div>

                            <div className="form-group">

                                <input
                                    className="form-control"
                                    type="text"
                                    label="Email"
                                    placeholder="Email"
                                    value={this.state.email}
                                    onChange={(event) => {
                                        this.setState({
                                            email: event.target.value
                                        });
                                    }}
                                />
                            </div>

                            <div className="form-group">
                                <input
                                    className="form-control"
                                    type="password"
                                    label="password"
                                    placeholder="Password"
                                    value={this.state.password}
                                    onChange={(event) => {
                                        this.setState({
                                            password: event.target.value
                                        });
                                    }}
                                />
                            </div>
                            <div className="form-group">
                                <div className="row">
                                    <div className="col-md-6">
                                        <br/>
                                        <input className="checkbox_label" type="checkbox" id="cb" name="remember me"/>

                                        <label className="checkbox_label"> I agree to dropbox terms.</label>
                                    </div>
                                    <div className="col-md-6">
                                        <br/>
                                        <button
                                            className="Registerbutton"
                                            type="button"
                                            onClick={this.props.handleCreateAccount.bind(this, JSON.stringify(this.state))}>
                                            Create an account
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div className="footer" id="footer">
              <div className="container">

            <div className="row">
                <div className="box">
                    <h3> DropBox </h3>
                    <ul>
                        <li> <a href="#">About Us </a> </li>
                        <li> <a href="#">Pricing </a> </li>

                        <li> <a href="#">Business </a> </li>
                        <li> <a href="#">Enterprise </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> About Us </h3>
                    <ul>
                        <li> <a href="#"> DropBox Blog </a> </li>
                        <li> <a href="#"> About </a> </li>
                        <li> <a href="#"> Branding </a> </li>

                        <li> <a href="#"> Careers </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> Support </h3>
                    <ul>
                        <li> <a href="#"> Help Center </a> </li>
                        <li> <a href="#"> Contact Us </a> </li>
                        <li> <a href="#"> Copyright </a> </li>

                        <li> <a href="#"> Privacy and Terms </a> </li>
                    </ul>
                </div>
                <div className="box">
                    <h3> Community </h3>
                    <ul>
                        <li> <a href="#"> Referrals </a> </li>
                        <li> <a href="#"> Forum </a> </li>

                        <li> <a href="#"> Facebook </a> </li>
                        <li> <a href="#"> Developers </a> </li>
                    </ul>
                </div>

            </div>

            </div>
    </div>

        </div>
        );


    }


    render() {
        if (this.state.signIn) {

            return this.renderSignIn();
        } else {
            return this.renderSignUp();
        }
    }

}


export default Login;
