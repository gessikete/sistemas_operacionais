#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(void){
	pid_t pid_id;
	
	pid_id = fork();
	
	if(pid_id == 0)
		printf("filho\n");
	else{
		printf("pai: aguarda fiho terminar\n");
		waitpid(pid_id, NULL, 0);
	}

	return;
}
