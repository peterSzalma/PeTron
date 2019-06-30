import React, {Component} from 'react';
import fire from './config/Fire';

class Login extends Component {
    constructor(props) {
        super(props);
        this.login = this.login.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.signup = this.signup.bind(this);
        this.state = {
            email: '',
            password: ''
        };
    }

    handleChange(e) {
        this.setState({[e.target.name]: e.target.value});
    }

    login(e) {
        e.preventDefault();
        fire.auth().signInWithEmailAndPassword(this.state.email, this.state.password).then((u) => {
        }).catch((error) => {
            console.log(error);
        });
    }

    signup(e) {
        e.preventDefault();
        fire.auth().createUserWithEmailAndPassword(this.state.email, this.state.password).then((u) => {
        }).then((u) => {
            console.log(u)
        })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-sm-9 col-md-7 col-lg-5 mx-auto">
                        <div className="card card-signin my-5">
                            <div className="card-body">
                                <h5 className="card-title text-center">Log In</h5>
                                <form className="form-signin"
                                      method="post">
                                    <div className="form-label-group">
                                        <input value={this.state.email} onChange={this.handleChange} type="email"
                                               name="email" className="form-control" id="exampleInputEmail1"
                                               aria-describedby="emailHelp" placeholder="Enter email"/>
                                               <label htmlFor="inputEmail">Email address</label>
                                    </div>

                                    <div className="form-label-group">
                                        <input value={this.state.password} onChange={this.handleChange} type="password"
                                               name="password" className="form-control" id="exampleInputPassword1"
                                               placeholder="Password"/>
                                            <label htmlFor="inputPassword">Password</label>
                                    </div>

                                    <div className="custom-control custom-checkbox mb-3">
                                        <input type="checkbox" className="custom-control-input" id="customCheck1"/>
                                            <label className="custom-control-label" htmlFor="customCheck1">Remember
                                                password</label>
                                    </div>
                                    <button className="btn btn-lg btn-primary btn-block text-uppercase" type="submit"
                                            onClick={this.login}>Log in
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    );
    }
    }
    export default Login;