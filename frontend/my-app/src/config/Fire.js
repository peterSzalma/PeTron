import firebase from 'firebase';

const config = { /* COPY THE ACTUAL CONFIG FROM FIREBASE CONSOLE */
    apiKey: "AIzaSyDDp_D1bS7HfrCMniPeCAwTI1L7lzkI4zc",
    authDomain: "petron-26dca.firebaseapp.com",
    databaseURL: "https://petron-26dca.firebaseio.com",
    projectId: "petron-26dca",
    storageBucket: "",
    messagingSenderId: "92361477168",
    appId: "1:92361477168:web:8c379b71f2060765"
};
const fire = firebase.initializeApp(config);
export default fire;