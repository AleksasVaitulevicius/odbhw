# odbhw

## Syntax for use

[command] [repository] [params]

[command] = get, add, put, delete
[command (only for pet)] = dogs, snakes
[repository] = owner, pet
[params] = 

E. g.: add pet dog Rex 11 5

## Repositories

### Commands of pet

* add pet dog <name> <times he fetched stick> <owner id> - adds new dog in repository
* add pet snake <name> < 0 | _ > <owner id>- adds new snake in repository (_ is wild card)
* get pet <(optional) id | name> - gets pet(s) from repository (if number then looks by id else by name, if not given then displays all pets)
* put pet <id> <dog | snake> <name> <times he fetched stick> <owner id> - sets new value of pet with given id 
* delete pet <id> - deletes pet with given id
* dogs pet - displays all dogs
* snakes pet - displays all snakes

### Commands of owner

* add owner <name> - adds new owner in repository
* get < (optional) id | name> - gets owner(s) from repository (if number then looks by id else by name, if not given then displays all owners)
* put <id> <dog | snake> <name> <times he fetched stick> <owner id> - sets new value of owner with given id
* delete <id> - deletes owner with given id
