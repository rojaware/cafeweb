# cafeweb

Cafe membership database application provide Java web based CRUD service with MySQL database. 

# how to create new repo from local source
Create the remote repository, and get the URL such as  https://github.com/rojaware/cafeweb.git

If your local GIT repo is already set up, skips steps 2 and 3

Locally, at the root directory of your source, git init

2a. If you initialize the repo with a .gitignore and a README.md you should do a git pull {url from step 1} to ensure you don't commit files to source that you want to ignore ;)

Locally, add and commit what you want in your initial repo (for everything, git add . then  git commit -m 'initial commit comment')

to attach your remote repo with the name 'origin' (like cloning would do)
git remote add origin [URL From Step 1]

Execute git pull origin master to pull the remote branch so that they are in sync.
to push up your master branch (change master to something else for a different branch):
git push origin master
