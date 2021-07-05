SUMMARY = "Printing env values recipe"
DESCRIPTION = "Print the various Env vars"

LICENSE = "MIT"

python do_printenv() {
    bb.plain("*************************");
    bb.plain("*************************");
} 

addtask printenv before do_build
