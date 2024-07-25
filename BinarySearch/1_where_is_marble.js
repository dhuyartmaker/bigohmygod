function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length - 1;

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);

        // if (arr[mid] === target && (mid === left || target != arr[mid - 1])) {
        if (arr[mid] === target) {
            return mid; // target found at index mid
        } else if (arr[mid] < target) {
            left = mid + 1; // search in the right half
        } else {
            right = mid - 1; // search in the left half
        }
    }

    return -1; // target not found
}

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
	solveProblem(input);
});

function solveProblem(inp) {
    let line = 0;
    let countCase = 1;
    while(true) {
        const nq = inp[line].split(' ').map(item => parseInt(item));
        let arrs = [];
        if (parseInt(nq[0]) === 0 && parseInt(nq[1]) === 0) break;
        // console.log("nq", nq)
        const N = parseInt(nq[0])
        const Q = parseInt(nq[1])
        for (let i = 0; i < N; i += 1) {
            line += 1;
            arrs.push(parseInt(inp[line]));
        }
        line += 1;

        console.log(`CASE# ${countCase}:`)
        arrs = arrs.sort((a,b) => a - b)
        // console.log("arrs", arrs)

        for (let i = 0; i < Q; i += 1) {
            const target = parseInt(inp[line]);
            const findPos = binarySearch(arrs, target)
            if (findPos >= 0) {
                console.log(`${target} found at ${findPos + 1}`)
            } else {
                console.log(`${target} not found`)
            }
            line += 1;
        }

        countCase += 1;
    }
}