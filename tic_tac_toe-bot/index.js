//Made by BurritoMan (https://github.com/burritoman70/burritomans-shitty-projects-with-shitty-code) 
//Version 1.0 on 24/07/2020 0:50 A.M. and commited 24/07/2020 at 01:35 A.M.
//Import the discord.js library
const discord=require("discord.js");
//Create a new client
const client=new discord.Client();
//Print ready when client is ready (DUH)
client.on("ready", () => {console.log("ready")});
//Declare state
var state=0;
// Declare challeger and challenged 
var challenger = {id:"", order:0, name: "",reset: ()=> {challenger.id="";challenger.order=0;challenger.name="";}};
var challenged = {id:"", order:0, name: "",reset: ()=> {challenged.id="";challenged.order=0;challenged.name="";}};
//Declare board, an object that contains the multiple methods related with the board used on the scrpt, such as checking whos won or marking box
var board = {
	boxes:["#","#","#","#","#","#","#","#","#"], 
	formatted: ()=> {
		var result="";
		for (i=0; i<board.boxes.length; i++) {
			if ( i%3 == 0) {
				result+="\n";
			};
			result+=board.boxes[i];
		};
		return result;
	},
	reset: () => {
		for (i=0; i<board.boxes.length; i++) {
			board.boxes[i]="#";
		};
	},
	mark: (box, simbol) => {
		simbol?simbol="O":simbol="X";
		if (board.boxes[box] == "#") { 
			board.boxes[box]=simbol; 
		} else {
			return 1;
		};
	},
	check: (simbol) => {
		var victory=1;
		simbol?formattedSimbol="O":formattedSimbol="X";
		switch (formattedSimbol+formattedSimbol+formattedSimbol) {
			case board.boxes[0]+board.boxes[1]+board.boxes[2]:
				return victory;
			break;
			case board.boxes[0]+board.boxes[3]+board.boxes[6]:
				return victory;
			break;
			case board.boxes[0]+board.boxes[4]+board.boxes[8]:
				return victory;
			break;
			case board.boxes[3]+board.boxes[4]+board.boxes[5]:
				return victory;
			break;
			case board.boxes[6]+board.boxes[7]+board.boxes[8]:
				return victory;
			break;
			case board.boxes[1]+board.boxes[4]+board.boxes[7]:
				return victory;
			break;
			case board.boxes[2]+board.boxes[5]+board.boxes[8]:
				return victory;
			break;
			case board.boxes[6]+board.boxes[4]+board.boxes[2]:
				return victory;
			break;
			default:
				return victory=0;
		};
	}
};
//Bot login
client.login();
//New message event
client.on("message", message => {
	//Regex to check whether the message sent is to be interpreted by the bot as a command
	const regChallenge = new RegExp("^!reto \<\@\![0-9]+\>$");
	const regAcceptChallenge = new RegExp("^!acepto$");
	const regRejectChallenge = new RegExp("^!deniego$");
	const regIdChallenged = new RegExp("[0-9]+");
	const regMove = new RegExp("^!marco [1-9]$");
	const regRenember = new RegExp("^!recordar$");
	const regSurrender = new RegExp("^!rendirse$");
	//Only accept from non-bots and from guild text channels
	if ( (!message.author.bot) && message.channel.type =="text") {
		//Used to check the state on which the games at
		switch (state) {
			//State 0, A.K.A. the challenge,  challenge a user w/ !reto <tag user>
			case 0:
				if ( regChallenge.test(message.content) ) { 
					challenged.id=regIdChallenged.exec(message.content)[0];
					//Checks whether the tagged user was a bot
					var isBot;
					message.guild.members.fetch(challenged.id)
					.then( query => {
						isBot = query.user.bot;
					});
					if (!isBot) {
						challenger.id=message.author.id;
						state++
					};
				};
			break;
			//State 1, A.K.A. the choice, whether the challenged accepts or denies the challenge
			case 1:
				//If the challenged user accepts the challenge the bot registers the users data for later on in the script
				if ( challenged.id == message.author.id && regAcceptChallenge.test(message.content) ) {
					challenger.order=Math.floor(Math.random()*2);
					challenger.order ? challenged.order=0 : challenged.order=1;
					message.guild.members.fetch(challenger.id)
					.then( query => {
						challenger.name = query.user.username;
					})
					.then( () => { message.guild.members.fetch(challenged.id)
						.then(query => {
							challenged.name = query.user.username;
						}) 
						.then( ()=> { challenged.order?
							message.channel.send("<@!"+challenger.id+">"+" va primero (X)"+board.formatted()):
							message.channel.send("<@!"+challenged.id+">"+" va primero (X)"+board.formatted());
						});
					});
					state++;
					//The challenge gets rejected
				} else if ( challenged.id == message.author.id && regRejectChallenge.test(message.content) ) {
					state=0;
					message.guild.members.fetch(challenged.id)
					.then( query => {
						message.channel.send("<@!"+challenger.id+">\n"+query.user.username+" ha denegado tu reto");
					});
				};
			break;
			//State 2+, A.K.A. the actual game, basically its just the game, checks whether the message was to surrender, renember or mark a box
			default:
				if ((message.author.id == challenger.id || message.author.id == challenged.id) && (regMove.test(message.content) || regRenember.test(message.content) || regSurrender.test(message.content))) {
					//This checks whether one of the participants surrendered
					if (regSurrender.test(message.content)) {
						if (message.author.id==challenger.id)	{
							loser=challenger;
							winner=challenged;
						} else { 
							loser=challenger; 
							winner=challenged;
						};
						message.channel.send(loser.name+" se ha rendido, "+winner.name+" resulta ganador"+board.formatted());
						challenged.reset();
						challenger.reset();
						board.reset();
						state=0;
						break;
					};
					//This next operation is to check whose turn is it
					state%2 == challenger.order?turn=challenger:turn=challenged;
					//The next statement is to check if one of the participants needs a refresher on the current of the game
					if (regRenember.test(message.content) == true) {
						turno.order?simbol=" (O)":simbol=" (X)";
						message.channel.send("Es el turno de "+turno.name+simbolo+board.formatted());
					};
					//From now onwards everything here is to mark a box and check the result of the game
					markedBox = parseInt(message.content.charAt(7))-1	
					if (message.author.id == turno.id && regMove.test(message.content)) {
						if (board.mark(markedBox,turno.order)) {
							break;
						};
						var victory;
						if (state >= 7) {
							victory=board.check(turn.order);
						}
						if (victory == 1) {
							message.channel.send("El duelo entre "+challenger.name+" y "+challenged.name+" ha terminado con "+turno.name+" como vencedor"+board.formatted());
							state=0;
							board.reset();
							challenged.reset();
							challenger.reset();
							break;
						};
						if (victory != 1 && state==11) {
							message.channel.send("El duelo entre "+challenger.name+" y "+challenged.name+" ha terminado en empate\n"+board.formatted());
							state=0;
							board.reset();
							challenged.reset();
							challenger.reset();
							break;
						};
						state%2 == challenger.order?
							message.channel.send("<@!"+challenged.id+">"+" es tu turno"+board.formatted()):
							message.channel.send("<@!"+challenger.id+">"+" es tu turno"+board.formatted()); 
						state++;
					};
				}
			};
		};
});
