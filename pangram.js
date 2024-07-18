const alphabet = 'abcdefghijklmnopqrstuvwxyz'.split('');
const mapping = alphabet.reduce((acc, item, index) => ({
    ...acc,
    [`${item}`]: 0,
}), {});

const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let input = [];
rl.on('line', (line) => {
	if (line.trim() === '0') {
		rl.close();
	} else {
		input.push(line);
	}
});

rl.on('close', () => {
	console.log(solveProblem(input));
});

function solveProblem(inp) {
    const n = parseInt(inp[0])
	const arrs = `${inp[1]}`.trim().split("")
    for (let i = 0; i < n; i += 1) {
        mapping[`${arrs[i]}`.toLowerCase()] += 1;
    }

    for (let i = 0; i < alphabet.length; i += 1) {
        if (mapping[`${alphabet[i]}`] === 0) return "NO"
    }

    return "YES"
}