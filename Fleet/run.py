from flask import Flask, render_template, request, redirect, url_for, session
from flask_mysqldb import MySQL
import MySQLdb.cursors
import logging

app = Flask(__name__)

# Change this to your secret key (can be anything, it's for extra protection)
app.secret_key = 'your secret key'

# Enter your database connection details below
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = 'nouhayla555'
app.config['MYSQL_DB'] = 'pythonlogin'

# Intialize MySQL
mysql = MySQL(app)

#flask routing
@app.route("/")
def home():
    return render_template("home.html")

 
@app.route('/register_now', methods =['GET', 'POST'])
def register_now():
      
    if request.method == 'POST' and 'username' in request.form and 'pw' in request.form and 'email' in request.form :
        username = request.form['username']
        password = request.form['pw']
        email = request.form['email']
        
        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        
        cursor.execute('INSERT INTO accounts (email,password,username) VALUES (% s, % s, % s)', (email, password,username ))
        mysql.connection.commit()
        return render_template('message.html',title='message')
    return render_template('register_now.html', title='register_now')



@app.route('/login', methods =['GET', 'POST'])
def login():
   
    if request.method == 'POST' and 'email' in request.form and 'pw' in request.form:
         
        password = request.form['pw']
        email = request.form['email']
        
        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        cursor.execute('SELECT * FROM accounts WHERE email = % s AND password = % s', (email, password ))
        account = cursor.fetchone()
        if account:
            session['loggedin'] = True
            session['id'] = account['id']
            session['email'] = account['email']
            
            return redirect('https://nouhaylabenhammou555.github.io/FleetManagementDashboard/')
 
        else:
             return render_template('forget_password.html', title='forget_password')
 

    return render_template('login.html', title='login')
 
@app.route('/logout')
def logout():
    return render_template('logout.html')
  
@app.route('/forget_password')
def forget_password(): 
    return render_template('forget_password.html', title='forget_password')     
 
@app.route('/reset_password', methods = ['GET','POST'])
def reset_password():
    if request.method == 'POST'  and 'new_pw' in request.form and 'new_password' in request.form and 'email' in request.form :
      
        new_password =request.form['new_password']
        em =request.form['email']
        new_pw = request.form['new_pw']
       

        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        if ( new_password==new_pw ):
             
             cursor.execute("UPDATE accounts SET password = %s WHERE email =%s",(new_password,em) )
             mysql.connection.commit()
             return render_template('login.html',title='login')
        return render_template('forget_password.html', title='forget_password')       
    return render_template('reset_password.html', title='reset_password')
 



@app.route('/contact')
def contact():
    return render_template('contact.html', title='contact') 
 
@app.route('/about')
def about():
    return render_template('about.html', title='about') 

@app.route('/demo')
def demo():
    return render_template('demo.html', title='demo')    

@app.route('/how_it_works')
def how_it_works():
    return render_template('how_it_works.html', title='how_it_works')      

 
@app.route('/message')
def message():
    return render_template('message.html', title='message')

 
@app.route('/blog')
def blog():
    return render_template('blog.html', title='blog')

@app.route('/blog1')
def blog1():
    return render_template('blog1.html', title='blog1')


@app.route('/blog2')
def blog2():
    return render_template('blog2.html', title='blog2')

@app.route('/blog3')
def blog3():
    return render_template('blog3.html', title='blog3')


@app.route('/blog4')
def blog4():
    return render_template('blog4.html', title='blog4')   
if  __name__=='__main__':
	 app.run()
 
