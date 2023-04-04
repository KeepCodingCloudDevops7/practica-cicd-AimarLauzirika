all: clean build exec
clean:
	@echo "\n-----------------------"
	@echo "---\033[36m\033[1m Cleaning Tagets \033[0m---"
	@echo "-----------------------"
	@mvn clean
build:
	@echo "\n--------------------------"
	@echo "---\033[36m\033[1m Building Artifacts \033[0m---"
	@echo "--------------------------"
	@mvn compile
exec:
	@echo "\n----------------------"
	@echo "---\033[36m\033[1m Executing App\033[0 \033[0m ---"
	@echo "----------------------"
	@mvn exec:java
test:
	@echo "\n--------------------------------"
	@echo "---\033[36m\033[1m Building ang Runing Test \033[0m---"
	@echo "--------------------------------"
	@mvn test