import { initializeApp } from "firebase/app";
import { getAuth, onAuthStateChanged, signOut } from "firebase/auth";
import firebase from 'firebase/compat/app';
import * as firebaseui from 'firebaseui';
import 'firebaseui/dist/firebaseui.css';
import { getFirestore, doc, setDoc, collection, getDocs } from "firebase/firestore";

// Firebase 配置
const firebaseConfig = {
    apiKey: "AIzaSyAWoUd5hGkBUjhyOVuwTDCVZMGQ_Xw7LaY",
    authDomain: "rich-web-lab5.firebaseapp.com",
    projectId: "rich-web-lab5",
    storageBucket: "rich-web-lab5.appspot.com",
    messagingSenderId: "648191978313",
    appId: "1:648191978313:web:0858f7b8d50cc0e76e0898",
    measurementId: "G-6BJM7BYDKL"
};

// 初始化 Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getFirestore(app);

// FirebaseUI 配置
const uiConfig = {
    signInOptions: [
        firebase.auth.EmailAuthProvider.PROVIDER_ID,
        firebase.auth.GoogleAuthProvider.PROVIDER_ID
    ],
    signInFlow: 'popup',
    callbacks: {
        signInSuccessWithAuthResult: () => false
    }
};

// 初始化 FirebaseUI
const ui = new firebaseui.auth.AuthUI(auth);

// 监控登录状态变化
onAuthStateChanged(auth, (user) => {
    if (user) {
        document.getElementById('auth').style.display = 'none';
        document.getElementById('main-app').style.display = 'block';

        document.getElementById('sign-out-btn').addEventListener('click', () => {
            signOut(auth).then(() => {
                window.location.reload();
            }).catch((error) => {
                console.error("退出登录时出错: ", error);
            });
        });
    } else {
        document.getElementById('auth').style.display = 'block';
        document.getElementById('main-app').style.display = 'none';
        ui.start('#auth', uiConfig);
    }
});

// 创建人员的功能
document.getElementById('create-person-btn').addEventListener('click', () => {
    document.getElementById('create-person-form').style.display = 'block';
    document.getElementById('people-list').style.display = 'none';
    document.getElementById('success-message').style.display = 'none';
});

document.getElementById('submit-person-btn').addEventListener('click', async () => {
    const personId = document.getElementById('person-id').value;
    const personName = document.getElementById('person-name').value;
    if (personId && personName) {
        try {
            await setDoc(doc(db, "people", personId), { name: personName });
            document.getElementById('create-person-form').style.display = 'none';
            document.getElementById('success-message').style.display = 'block';
            document.getElementById('person-id').value = '';
            document.getElementById('person-name').value = '';
        } catch (error) {
            console.error("Error adding person:", error);
        }
    } else {
        alert("Please fill in both ID and Name.");
    }
});

// 列出人员的功能
document.getElementById('list-people-btn').addEventListener('click', async () => {
    document.getElementById('create-person-form').style.display = 'none';
    document.getElementById('people-list').style.display = 'block';
    document.getElementById('success-message').style.display = 'none';

    try {
        const querySnapshot = await getDocs(collection(db, "people"));
        const peopleTbody = document.getElementById('people-tbody');
        peopleTbody.innerHTML = '';
        querySnapshot.forEach((doc) => {
            const row = document.createElement('tr');
            const idCell = document.createElement('td');
            const nameCell = document.createElement('td');
            idCell.textContent = doc.id;
            nameCell.textContent = doc.data().name;
            row.appendChild(idCell);
            row.appendChild(nameCell);
            peopleTbody.appendChild(row);
        });
    } catch (error) {
        console.error("Error getting people list:", error);
    }
});
