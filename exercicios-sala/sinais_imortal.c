void handler(int signal){
  printf("SOU IMORTAL!!");
}

int main(){
  pid_t procID;
  
  /* chama o handler quando tentar matar o processo com o comando kill */
  signal(SIGKILL, handler);
  
  /* chama o handler uqando tentar matar o processo com ctrl+c */
  signal(handler);
  
  while(1){
    sleep(1);
  }
  
  return 0;
}