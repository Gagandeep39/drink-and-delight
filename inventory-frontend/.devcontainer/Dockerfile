FROM node:14-alpine
##############################################################
################        Installing Packages     ##############
##############################################################
RUN apk add git && apk add zsh
##############################################################
################            Create User        ###############
##############################################################
# Comment below code and rebuild t fix permission issue
# RUN addgroup -S appgroup && adduser -S gagan -G appgroup
USER root
##############################################################
################            ZSH Config        ################
##############################################################
# run the installation script  
RUN sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"
# RUN sh -c "$(wget -O- https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
# install powerlevel10k
RUN git clone https://github.com/romkatv/powerlevel10k.git ~/.oh-my-zsh/custom/themes/powerlevel10k
# Syntax Plugin
RUN git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
# Autocomplete
RUN git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
