# odbhw

## Syntax for use

[command] [repository] [params]

[command] = get, add, put, delete

[command (only for pet)] = dogs, snakes

[repository] = owner, pet

## Repositories

### Commands of pet

* add pet dog <name> <times he fetched stick> <owner id> - adds new dog in repository
* add pet snake <name> < 0 | _ > <owner id>- adds new snake in repository (< 0 | _ > - if 0, then skin is not shedding, else shedding, _ is wild card)
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
  
## Examples

add pet dog Rex 11 5

add pet snake Doodle 0 3

get owner Tom

get owner

get pet 1

dogs pet

snakes pet

put pet 1 Rex 12 5

delte pet 1
