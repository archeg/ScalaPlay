



<!DOCTYPE html>
<html lang="en" class=" is-copy-enabled">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=1020">
    
    
    <title>ScalaPlay/Graphs_80.scala at master · archeg/ScalaPlay</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png">
    <meta property="fb:app_id" content="1401488693436528">

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="archeg/ScalaPlay" name="twitter:title" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." name="twitter:description" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" name="twitter:image:src" />
      <meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" property="og:image" /><meta content="archeg/ScalaPlay" property="og:title" /><meta content="https://github.com/archeg/ScalaPlay" property="og:url" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." property="og:description" />
      <meta name="browser-stats-url" content="https://api.github.com/_private/browser/stats">
    <meta name="browser-errors-url" content="https://api.github.com/_private/browser/errors">
    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="web-socket" href="wss://live.github.com/_sockets/NzAwMDk0OmUwMTRjMWE2ZmQwMzdmM2MwMWRkMzM0NWNkZTQ5ODIyOmU2NzI0NGY2ZDM2M2FjMTkyZjQyNjIxYjBiYzlkM2Q2ZmU3ZGIxNjJjM2YxMjg1YWNlNTVjMGJkYWI4ZDQzY2U=--8995dea51b476d08f39934c5cb4bcbd3528cdfa6">
    <meta name="pjax-timeout" content="1000">
    <link rel="sudo-modal" href="/sessions/sudo_modal">

    <meta name="msapplication-TileImage" content="/windows-tile.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="selected-link" value="repo_source" data-pjax-transient>

    <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="1FDFE7A5:448A:11D52EC0:5670A2BE" name="octolytics-dimension-request_id" /><meta content="700094" name="octolytics-actor-id" /><meta content="archeg" name="octolytics-actor-login" /><meta content="36ffb8bf8138a474da1e7d225cbe063bf44ca2befebe1f9bda1e644a749d0c74" name="octolytics-actor-hash" />
<meta content="/&lt;user-name&gt;/&lt;repo-name&gt;/blob/show" data-pjax-transient="true" name="analytics-location" />
<meta content="Rails, view, blob#show" data-pjax-transient="true" name="analytics-event" />


  <meta class="js-ga-set" name="dimension1" content="Logged In">



        <meta name="hostname" content="github.com">
    <meta name="user-login" content="archeg">

        <meta name="expected-hostname" content="github.com">

      <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#4078c0">
      <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">

    <meta content="c8ba129f3cd8063df505087e410775fa587c3890" name="form-nonce" />

    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-502ab50993b65c1ac75efa286ffd5304245f6c9bb4171ac014fbcf92f6f688de.css" integrity="sha256-UCq1CZO2XBrHXvoob/1TBCRfbJu0FxrAFPvPkvb2iN4=" media="all" rel="stylesheet" />
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github2-ebf42d255e330ca3f7549dac879de43cf65f82c36670b5628077508fdf3b1c44.css" integrity="sha256-6/QtJV4zDKP3VJ2sh53kPPZfgsNmcLVigHdQj987HEQ=" media="all" rel="stylesheet" />
    
    


    <meta http-equiv="x-pjax-version" content="cd9958d45e48e8e3157a320e9c346eaa">

      
  <meta name="description" content="ScalaPlay - Repository where I play with scala. Nothing of importance.">
  <meta name="go-import" content="github.com/archeg/ScalaPlay git https://github.com/archeg/ScalaPlay.git">

  <meta content="700094" name="octolytics-dimension-user_id" /><meta content="archeg" name="octolytics-dimension-user_login" /><meta content="48056280" name="octolytics-dimension-repository_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="48056280" name="octolytics-dimension-repository_network_root_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/archeg/ScalaPlay/commits/master.atom" rel="alternate" title="Recent Commits to ScalaPlay:master" type="application/atom+xml">

  </head>


  <body class="logged_in   env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>

    
    
    



      <div class="header header-logged-in true" role="banner">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
  <span class="mega-octicon octicon-mark-github"></span>
</a>


      <div class="site-search repo-scope js-site-search" role="search">
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/search" class="js-site-search-form" data-global-search-url="/search" data-repo-search-url="/archeg/ScalaPlay/search" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
  <label class="js-chromeless-input-container form-control">
    <div class="scope-badge">This repository</div>
    <input type="text"
      class="js-site-search-focus js-site-search-field is-clearable chromeless-input"
      data-hotkey="s"
      name="q"
      placeholder="Search"
      aria-label="Search this repository"
      data-global-scope-placeholder="Search GitHub"
      data-repo-scope-placeholder="Search"
      tabindex="1"
      autocapitalize="off">
  </label>
</form>
      </div>

      <ul class="header-nav left" role="navigation">
        <li class="header-nav-item">
          <a href="/pulls" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:pulls context:user" data-hotkey="g p" data-selected-links="/pulls /pulls/assigned /pulls/mentioned /pulls">
            Pull requests
</a>        </li>
        <li class="header-nav-item">
          <a href="/issues" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:issues context:user" data-hotkey="g i" data-selected-links="/issues /issues/assigned /issues/mentioned /issues">
            Issues
</a>        </li>
          <li class="header-nav-item">
            <a class="header-nav-link" href="https://gist.github.com/" data-ga-click="Header, go to gist, text:gist">Gist</a>
          </li>
      </ul>

    
<ul class="header-nav user-nav right" id="user-links">
  <li class="header-nav-item">
      <span class="js-socket-channel js-updatable-content"
        data-channel="notification-changed:archeg"
        data-url="/notifications/header">
      <a href="/notifications" aria-label="You have unread notifications" class="header-nav-link notification-indicator tooltipped tooltipped-s" data-ga-click="Header, go to notifications, icon:unread" data-hotkey="g n">
          <span class="mail-status unread"></span>
          <span class="octicon octicon-bell"></span>
</a>  </span>

  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link tooltipped tooltipped-s js-menu-target" href="/new"
       aria-label="Create new…"
       data-ga-click="Header, create new, icon:add">
      <span class="octicon octicon-plus left"></span>
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <ul class="dropdown-menu dropdown-menu-sw">
        
<a class="dropdown-item" href="/new" data-ga-click="Header, create new repository">
  New repository
</a>


  <a class="dropdown-item" href="/organizations/new" data-ga-click="Header, create new organization">
    New organization
  </a>



  <div class="dropdown-divider"></div>
  <div class="dropdown-header">
    <span title="archeg/ScalaPlay">This repository</span>
  </div>
    <a class="dropdown-item" href="/archeg/ScalaPlay/issues/new" data-ga-click="Header, create new issue">
      New issue
    </a>
    <a class="dropdown-item" href="/archeg/ScalaPlay/settings/collaboration" data-ga-click="Header, create new collaborator">
      New collaborator
    </a>

      </ul>
    </div>
  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link name tooltipped tooltipped-sw js-menu-target" href="/archeg"
       aria-label="View profile and more"
       data-ga-click="Header, show menu, icon:avatar">
      <img alt="@archeg" class="avatar" height="20" src="https://avatars1.githubusercontent.com/u/700094?v=3&amp;s=40" width="20" />
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <div class="dropdown-menu  dropdown-menu-sw">
        <div class=" dropdown-header header-nav-current-user css-truncate">
            Signed in as <strong class="css-truncate-target">archeg</strong>

        </div>


        <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/archeg" data-ga-click="Header, go to profile, text:your profile">
            Your profile
          </a>
        <a class="dropdown-item" href="/stars" data-ga-click="Header, go to starred repos, text:your stars">
          Your stars
        </a>
        <a class="dropdown-item" href="/explore" data-ga-click="Header, go to explore, text:explore">
          Explore
        </a>
          <a class="dropdown-item" href="/integrations" data-ga-click="Header, go to integrations, text:integrations">
            Integrations
          </a>
        <a class="dropdown-item" href="https://help.github.com" data-ga-click="Header, go to help, text:help">
          Help
        </a>

          <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/settings/profile" data-ga-click="Header, go to settings, icon:settings">
            Settings
          </a>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/logout" class="logout-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="rUR0/KXEyoPJNtJEqVM55TotHE6lRKNcuUKOb2R6untmfF1cPDCpwuIeIGxmeHJSPj2bG8hmtnSFDUOjynJvkA==" /></div>
            <button class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout">
              Sign out
            </button>
</form>
      </div>
    </div>
  </li>
</ul>


    
  </div>
</div>

      

      


    <div id="start-of-content" class="accessibility-aid"></div>

      <div id="js-flash-container">
</div>


    <div role="main" class="main-content">
        <div itemscope itemtype="http://schema.org/WebPage">
    <div id="js-repo-pjax-container" class="context-loader-container js-repo-nav-next" data-pjax-container>
      
<div class="pagehead repohead instapaper_ignore readability-menu experiment-repo-nav">
  <div class="container repohead-details-container">

    

<ul class="pagehead-actions">

  <li>
        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="+qMrfUQ/Bx7vk3SrChfQfW8x/B9CzG74bQY7s6FcoYUjNKimTCw0NyUokdkUW+LSSJ5JaSNeNqm2vLQkm3OXqA==" /></div>      <input id="repository_id" name="repository_id" type="hidden" value="48056280" />

        <div class="select-menu js-menu-container js-select-menu">
          <a href="/archeg/ScalaPlay/subscription"
            class="btn btn-sm btn-with-count select-menu-button js-menu-target" role="button" tabindex="0" aria-haspopup="true"
            data-ga-click="Repository, click Watch settings, action:blob#show">
            <span class="js-select-button">
              <span class="octicon octicon-eye"></span>
              Unwatch
            </span>
          </a>
          <a class="social-count js-social-count" href="/archeg/ScalaPlay/watchers">
            1
          </a>

        <div class="select-menu-modal-holder">
          <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
            <div class="select-menu-header">
              <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
              <span class="select-menu-title">Notifications</span>
            </div>

              <div class="select-menu-list js-navigation-container" role="menu">

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_included" name="do" type="radio" value="included" />
                    <span class="select-menu-item-heading">Not watching</span>
                    <span class="description">Be notified when participating or @mentioned.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Watch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                    <span class="select-menu-item-heading">Watching</span>
                    <span class="description">Be notified of all conversations.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Unwatch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_ignore" name="do" type="radio" value="ignore" />
                    <span class="select-menu-item-heading">Ignoring</span>
                    <span class="description">Never be notified.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-mute"></span>
                      Stop ignoring
                    </span>
                  </div>
                </div>

              </div>

            </div>
          </div>
        </div>
</form>
  </li>

  <li>
    
  <div class="js-toggler-container js-social-container starring-container ">

    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/unstar" class="js-toggler-form starred js-unstar-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="K8d1z+F2agP4BnCTwSg9GtJoci6yRhMyn5fUBkWqSpdnYgE4sZkoDA3pmz1pGXktv2AXXAL/3Yp0z0//05VdeQ==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Unstar this repository" title="Unstar archeg/ScalaPlay"
        data-ga-click="Repository, click unstar button, action:blob#show; text:Unstar">
        <span class="octicon octicon-star"></span>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>
    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/star" class="js-toggler-form unstarred js-star-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="GIxnf82lSdq0tEbVC4LJq6bQaFTg4naU4KKhJQl85GWvdMBHqY4DN45VloRj2t8E44qL4Ks/QM5TPND8OwFtdw==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Star this repository" title="Star archeg/ScalaPlay"
        data-ga-click="Repository, click star button, action:blob#show; text:Star">
        <span class="octicon octicon-star"></span>
        Star
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>  </div>

  </li>

  <li>
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/fork" class="btn-with-count" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="m5wxez/RkWhry9jsSto5nU7swa8TXx+ZnV/4m9YjGrfZ3inrZHCjxek2FLUSCf8rcv3S9QyndGHruA2rFtYaSg==" /></div>
            <button
                type="submit"
                class="btn btn-sm btn-with-count"
                data-ga-click="Repository, show fork modal, action:blob#show; text:Fork"
                title="Fork your own copy of archeg/ScalaPlay to your account"
                aria-label="Fork your own copy of archeg/ScalaPlay to your account">
              <span class="octicon octicon-repo-forked"></span>
              Fork
            </button>
</form>
    <a href="/archeg/ScalaPlay/network" class="social-count">
      0
    </a>
  </li>
</ul>

    <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public ">
  <span class="octicon octicon-repo"></span>
  <span class="author"><a href="/archeg" class="url fn" itemprop="url" rel="author"><span itemprop="title">archeg</span></a></span><!--
--><span class="path-divider">/</span><!--
--><strong><a href="/archeg/ScalaPlay" data-pjax="#js-repo-pjax-container">ScalaPlay</a></strong>

  <span class="page-context-loader">
    <img alt="" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
  </span>

</h1>

  </div>
  <div class="container">
    
<nav class="reponav js-repo-nav js-sidenav-container-pjax js-octicon-loaders"
     role="navigation"
     data-pjax="#js-repo-pjax-container">

  <a href="/archeg/ScalaPlay" aria-label="Code" aria-selected="true" class="js-selected-navigation-item selected reponav-item" data-hotkey="g c" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /archeg/ScalaPlay">
    <span class="octicon octicon-code"></span>
    Code
</a>
    <a href="/archeg/ScalaPlay/issues" class="js-selected-navigation-item reponav-item" data-hotkey="g i" data-selected-links="repo_issues repo_labels repo_milestones /archeg/ScalaPlay/issues">
      <span class="octicon octicon-issue-opened"></span>
      Issues
      <span class="counter">0</span>
</a>
  <a href="/archeg/ScalaPlay/pulls" class="js-selected-navigation-item reponav-item" data-hotkey="g p" data-selected-links="repo_pulls /archeg/ScalaPlay/pulls">
    <span class="octicon octicon-git-pull-request"></span>
    Pull requests
    <span class="counter">0</span>
</a>
    <a href="/archeg/ScalaPlay/wiki" class="js-selected-navigation-item reponav-item" data-hotkey="g w" data-selected-links="repo_wiki /archeg/ScalaPlay/wiki">
      <span class="octicon octicon-book"></span>
      Wiki
</a>
  <a href="/archeg/ScalaPlay/pulse" class="js-selected-navigation-item reponav-item" data-selected-links="pulse /archeg/ScalaPlay/pulse">
    <span class="octicon octicon-pulse"></span>
    Pulse
</a>
  <a href="/archeg/ScalaPlay/graphs" class="js-selected-navigation-item reponav-item" data-selected-links="repo_graphs repo_contributors /archeg/ScalaPlay/graphs">
    <span class="octicon octicon-graph"></span>
    Graphs
</a>
    <a href="/archeg/ScalaPlay/settings" class="js-selected-navigation-item reponav-item" data-selected-links="repo_settings repo_branch_settings hooks /archeg/ScalaPlay/settings">
      <span class="octicon octicon-gear"></span>
      Settings
</a>
</nav>

  </div>
</div>

<div class="container new-discussion-timeline experiment-repo-nav">
  <div class="repository-content">

    

<a href="/archeg/ScalaPlay/blob/3e975fc4e13904bcb93b66fe4b239a9a6aeeb7e3/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:c10cbfcd4fd5d55ddcd26c0b73d4dcdd -->

<div class="file-navigation js-zeroclipboard-container">
  
<div class="select-menu js-menu-container js-select-menu left">
  <button class="btn btn-sm select-menu-button js-menu-target css-truncate" data-hotkey="w"
    title="master"
    type="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <i>Branch:</i>
    <span class="js-select-button css-truncate-target">master</span>
  </button>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
        <span class="select-menu-title">Switch branches/tags</span>
      </div>

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" data-filter-placeholder="Find or create a branch…" class="js-select-menu-tab" role="tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" data-filter-placeholder="Find a tag…" class="js-select-menu-tab" role="tab">Tags</a>
            </li>
          </ul>
        </div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches" role="menu">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <a class="select-menu-item js-navigation-item js-navigation-open selected"
               href="/archeg/ScalaPlay/blob/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="master">
                master
              </span>
            </a>
        </div>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="E4SHfvd+rLc/+tWBJJUZmNmGsvNJL3ciSKnq2QC4h4dPGmPdOf2X967Z+Uz7UUQ4bTwq+DQlvz5EgLAswGgfgA==" /></div>
            <span class="octicon octicon-git-branch select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <span class="select-menu-item-heading">Create branch: <span class="js-new-item-name"></span></span>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master">
            <input type="hidden" name="path" id="path" value="ninetyNineScalaProblems/src/main/scala/Graphs_80.scala">
</form>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div>

    </div>
  </div>
</div>

  <div class="btn-group right">
    <a href="/archeg/ScalaPlay/find/master"
          class="js-show-file-finder btn btn-sm"
          data-pjax
          data-hotkey="t">
      Find file
    </a>
    <button aria-label="Copy file path to clipboard" class="js-zeroclipboard btn btn-sm zeroclipboard-button tooltipped tooltipped-s" data-copied-hint="Copied!" type="button">Copy path</button>
  </div>
  <div class="breadcrumb js-zeroclipboard-target">
    <span class="repo-root js-repo-root"><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ScalaPlay</span></a></span></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ninetyNineScalaProblems</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">main</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main/scala" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">scala</span></a></span><span class="separator">/</span><strong class="final-path">Graphs_80.scala</strong>
  </div>
</div>

<include-fragment class="commit-tease" src="/archeg/ScalaPlay/contributors/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala">
  <div>
    Fetching contributors&hellip;
  </div>

  <div class="commit-tease-contributors">
    <img alt="" class="loader-loading left" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32-EAF2F5.gif" width="16" />
    <span class="loader-error">Cannot retrieve contributors at this time</span>
  </div>
</include-fragment>
<div class="file">
  <div class="file-header">
  <div class="file-actions">

    <div class="btn-group">
      <a href="/archeg/ScalaPlay/raw/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="btn btn-sm " id="raw-url">Raw</a>
        <a href="/archeg/ScalaPlay/blame/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="btn btn-sm js-update-url-with-hash">Blame</a>
      <a href="/archeg/ScalaPlay/commits/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="btn btn-sm " rel="nofollow">History</a>
    </div>

        <a class="octicon-btn tooltipped tooltipped-nw"
           href="github-windows://openRepo/https://github.com/archeg/ScalaPlay?branch=master&amp;filepath=ninetyNineScalaProblems%2Fsrc%2Fmain%2Fscala%2FGraphs_80.scala"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <span class="octicon octicon-device-desktop"></span>
        </a>

        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/edit/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="inline-form js-update-url-with-hash" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="N428i9wvwsLdbgSqfiz1hYHSg32yEbz2J6cA026Pma2rSfWZleBiQxjnoaS1WODviOkbUbS50sALEpZUY+BIHg==" /></div>
          <button class="octicon-btn tooltipped tooltipped-nw" type="submit"
            aria-label="Edit this file" data-hotkey="e" data-disable-with>
            <span class="octicon octicon-pencil"></span>
          </button>
</form>        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/delete/master/ninetyNineScalaProblems/src/main/scala/Graphs_80.scala" class="inline-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="ZWpKNqwj9L9YyziIC/LuJzKy4rRmGyJXDfzuo3IAw/fh5rhxhO8loX8+u/Rh0hy1l/QVSuZ+TZ1V7Mju/Ro7LQ==" /></div>
          <button class="octicon-btn octicon-btn-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Delete this file" data-disable-with>
            <span class="octicon octicon-trashcan"></span>
          </button>
</form>  </div>

  <div class="file-info">
      586 lines (478 sloc)
      <span class="file-info-divider"></span>
    23 KB
  </div>
</div>

  

  <div class="blob-wrapper data type-scala">
      <table class="highlight tab-size js-file-line-container" data-tab-size="8">
      <tr>
        <td id="L1" class="blob-num js-line-number" data-line-number="1"></td>
        <td id="LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/*</span></td>
      </tr>
      <tr>
        <td id="L2" class="blob-num js-line-number" data-line-number="2"></td>
        <td id="LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)</span></td>
      </tr>
      <tr>
        <td id="L3" class="blob-num js-line-number" data-line-number="3"></td>
        <td id="LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> */</span></td>
      </tr>
      <tr>
        <td id="L4" class="blob-num js-line-number" data-line-number="4"></td>
        <td id="LC4" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L5" class="blob-num js-line-number" data-line-number="5"></td>
        <td id="LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">package</span> <span class="pl-en">NinetyNineScalaProblem</span></td>
      </tr>
      <tr>
        <td id="L6" class="blob-num js-line-number" data-line-number="6"></td>
        <td id="LC6" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L7" class="blob-num js-line-number" data-line-number="7"></td>
        <td id="LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">CommonPlay.</span><span class="pl-v">ChapterApp</span></td>
      </tr>
      <tr>
        <td id="L8" class="blob-num js-line-number" data-line-number="8"></td>
        <td id="LC8" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L9" class="blob-num js-line-number" data-line-number="9"></td>
        <td id="LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">scala.annotation.</span><span class="pl-v">tailrec</span></td>
      </tr>
      <tr>
        <td id="L10" class="blob-num js-line-number" data-line-number="10"></td>
        <td id="LC10" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L11" class="blob-num js-line-number" data-line-number="11"></td>
        <td id="LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/**</span></td>
      </tr>
      <tr>
        <td id="L12" class="blob-num js-line-number" data-line-number="12"></td>
        <td id="LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  * Created by archeg on 11/24/2015.</span></td>
      </tr>
      <tr>
        <td id="L13" class="blob-num js-line-number" data-line-number="13"></td>
        <td id="LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  */</span></td>
      </tr>
      <tr>
        <td id="L14" class="blob-num js-line-number" data-line-number="14"></td>
        <td id="LC14" class="blob-code blob-code-inner js-file-line"><span class="pl-k">object</span> <span class="pl-en">Graphs_80</span> <span class="pl-k">extends</span> <span class="pl-e">ChapterApp</span> {</td>
      </tr>
      <tr>
        <td id="L15" class="blob-num js-line-number" data-line-number="15"></td>
        <td id="LC15" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">abstract</span> <span class="pl-k">class</span> <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] {</td>
      </tr>
      <tr>
        <td id="L16" class="blob-num js-line-number" data-line-number="16"></td>
        <td id="LC16" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">Edge</span>(<span class="pl-v">n1</span>: <span class="pl-en">Node</span>, <span class="pl-v">n2</span>: <span class="pl-en">Node</span>, <span class="pl-v">value</span>: <span class="pl-en">Option</span>[<span class="pl-en">U</span>]) {</td>
      </tr>
      <tr>
        <td id="L17" class="blob-num js-line-number" data-line-number="17"></td>
        <td id="LC17" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">def</span> <span class="pl-en">toTuple</span> <span class="pl-k">=</span> (n1.value, n2.value, value)</td>
      </tr>
      <tr>
        <td id="L18" class="blob-num js-line-number" data-line-number="18"></td>
        <td id="LC18" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> (n1, n2, value) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L19" class="blob-num js-line-number" data-line-number="19"></td>
        <td id="LC19" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-en">Node</span>(v1), <span class="pl-en">Node</span>(v2), <span class="pl-c1">None</span>) <span class="pl-k">=&gt;</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>$v1-$v2<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L20" class="blob-num js-line-number" data-line-number="20"></td>
        <td id="LC20" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-en">Node</span>(v1), <span class="pl-en">Node</span>(v2), <span class="pl-en">Some</span>(value)) <span class="pl-k">=&gt;</span> s<span class="pl-s"><span class="pl-pds">&quot;</span>$v1-$v2//$value<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L21" class="blob-num js-line-number" data-line-number="21"></td>
        <td id="LC21" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L22" class="blob-num js-line-number" data-line-number="22"></td>
        <td id="LC22" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L23" class="blob-num js-line-number" data-line-number="23"></td>
        <td id="LC23" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L24" class="blob-num js-line-number" data-line-number="24"></td>
        <td id="LC24" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">Node</span>(<span class="pl-v">value</span>: <span class="pl-en">T</span>) {</td>
      </tr>
      <tr>
        <td id="L25" class="blob-num js-line-number" data-line-number="25"></td>
        <td id="LC25" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">var</span> <span class="pl-en">adj</span><span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Edge</span>] <span class="pl-k">=</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L26" class="blob-num js-line-number" data-line-number="26"></td>
        <td id="LC26" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">def</span> <span class="pl-en">neighbors</span><span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Node</span>] <span class="pl-k">=</span> adj.map(edgeTarget(_, <span class="pl-v">this</span>).get)</td>
      </tr>
      <tr>
        <td id="L27" class="blob-num js-line-number" data-line-number="27"></td>
        <td id="LC27" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L28" class="blob-num js-line-number" data-line-number="28"></td>
        <td id="LC28" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L29" class="blob-num js-line-number" data-line-number="29"></td>
        <td id="LC29" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">var</span> <span class="pl-en">nodes</span><span class="pl-k">:</span> <span class="pl-en">Map</span>[<span class="pl-en">T</span>, <span class="pl-en">Node</span>] <span class="pl-k">=</span> <span class="pl-en">Map</span>()</td>
      </tr>
      <tr>
        <td id="L30" class="blob-num js-line-number" data-line-number="30"></td>
        <td id="LC30" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">var</span> <span class="pl-en">edges</span><span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Edge</span>] <span class="pl-k">=</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L31" class="blob-num js-line-number" data-line-number="31"></td>
        <td id="LC31" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L32" class="blob-num js-line-number" data-line-number="32"></td>
        <td id="LC32" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">// If the edge E connects N to another node, returns the other node,</span></td>
      </tr>
      <tr>
        <td id="L33" class="blob-num js-line-number" data-line-number="33"></td>
        <td id="LC33" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">// otherwise returns None.</span></td>
      </tr>
      <tr>
        <td id="L34" class="blob-num js-line-number" data-line-number="34"></td>
        <td id="LC34" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">edgeTarget</span>(<span class="pl-v">e</span>: <span class="pl-en">Edge</span>, <span class="pl-v">n</span>: <span class="pl-en">Node</span>)<span class="pl-k">:</span> <span class="pl-en">Option</span>[<span class="pl-en">Node</span>]</td>
      </tr>
      <tr>
        <td id="L35" class="blob-num js-line-number" data-line-number="35"></td>
        <td id="LC35" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L36" class="blob-num js-line-number" data-line-number="36"></td>
        <td id="LC36" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">equals</span>(<span class="pl-v">o</span>: <span class="pl-en">Any</span>) <span class="pl-k">=</span> o <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L37" class="blob-num js-line-number" data-line-number="37"></td>
        <td id="LC37" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-v">g</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>,<span class="pl-en">U</span>] <span class="pl-k">=&gt;</span> (nodes.keys.toSet diff g.nodes.keys.toSet) <span class="pl-k">==</span> <span class="pl-en">Set</span>.empty <span class="pl-k">&amp;&amp;</span></td>
      </tr>
      <tr>
        <td id="L38" class="blob-num js-line-number" data-line-number="38"></td>
        <td id="LC38" class="blob-code blob-code-inner js-file-line">          (edges.map(_.toTuple) diff g.edges.map(_.toTuple)) <span class="pl-k">==</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L39" class="blob-num js-line-number" data-line-number="39"></td>
        <td id="LC39" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L40" class="blob-num js-line-number" data-line-number="40"></td>
        <td id="LC40" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L41" class="blob-num js-line-number" data-line-number="41"></td>
        <td id="LC41" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L42" class="blob-num js-line-number" data-line-number="42"></td>
        <td id="LC42" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">hashCode</span>()<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> nodes.keys.map(_.hashCode()).sum <span class="pl-k">+</span> ((edges map {</td>
      </tr>
      <tr>
        <td id="L43" class="blob-num js-line-number" data-line-number="43"></td>
        <td id="LC43" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Edge</span>(<span class="pl-en">Node</span>(n1), <span class="pl-en">Node</span>(n2), <span class="pl-en">Some</span>(value)) <span class="pl-k">=&gt;</span> n1.hashCode() <span class="pl-k">+</span> n2.hashCode() <span class="pl-k">+</span> value.hashCode()</td>
      </tr>
      <tr>
        <td id="L44" class="blob-num js-line-number" data-line-number="44"></td>
        <td id="LC44" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Edge</span>(<span class="pl-en">Node</span>(n1), <span class="pl-en">Node</span>(n2), <span class="pl-c1">None</span>) <span class="pl-k">=&gt;</span> n1.hashCode() <span class="pl-k">+</span> n2.hashCode()</td>
      </tr>
      <tr>
        <td id="L45" class="blob-num js-line-number" data-line-number="45"></td>
        <td id="LC45" class="blob-code blob-code-inner js-file-line">    }).sum)</td>
      </tr>
      <tr>
        <td id="L46" class="blob-num js-line-number" data-line-number="46"></td>
        <td id="LC46" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L47" class="blob-num js-line-number" data-line-number="47"></td>
        <td id="LC47" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addNode</span>(<span class="pl-v">value</span>: <span class="pl-en">T</span>) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L48" class="blob-num js-line-number" data-line-number="48"></td>
        <td id="LC48" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">n</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Node</span>(value)</td>
      </tr>
      <tr>
        <td id="L49" class="blob-num js-line-number" data-line-number="49"></td>
        <td id="LC49" class="blob-code blob-code-inner js-file-line">      nodes <span class="pl-k">=</span> <span class="pl-en">Map</span>(value <span class="pl-k">-</span><span class="pl-k">&gt;</span> n) <span class="pl-k">++</span> nodes</td>
      </tr>
      <tr>
        <td id="L50" class="blob-num js-line-number" data-line-number="50"></td>
        <td id="LC50" class="blob-code blob-code-inner js-file-line">      n</td>
      </tr>
      <tr>
        <td id="L51" class="blob-num js-line-number" data-line-number="51"></td>
        <td id="LC51" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L52" class="blob-num js-line-number" data-line-number="52"></td>
        <td id="LC52" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L53" class="blob-num js-line-number" data-line-number="53"></td>
        <td id="LC53" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L54" class="blob-num js-line-number" data-line-number="54"></td>
        <td id="LC54" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L55" class="blob-num js-line-number" data-line-number="55"></td>
        <td id="LC55" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">class</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] <span class="pl-k">extends</span> <span class="pl-e">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] {</td>
      </tr>
      <tr>
        <td id="L56" class="blob-num js-line-number" data-line-number="56"></td>
        <td id="LC56" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">equals</span>(<span class="pl-v">o</span>: <span class="pl-en">Any</span>) <span class="pl-k">=</span> o <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L57" class="blob-num js-line-number" data-line-number="57"></td>
        <td id="LC57" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>,<span class="pl-en">U</span>] <span class="pl-k">=&gt;</span> <span class="pl-v">super</span>.equals(g)</td>
      </tr>
      <tr>
        <td id="L58" class="blob-num js-line-number" data-line-number="58"></td>
        <td id="LC58" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L59" class="blob-num js-line-number" data-line-number="59"></td>
        <td id="LC59" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L60" class="blob-num js-line-number" data-line-number="60"></td>
        <td id="LC60" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L61" class="blob-num js-line-number" data-line-number="61"></td>
        <td id="LC61" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">edgeTarget</span>(<span class="pl-v">e</span>: <span class="pl-en">Edge</span>, <span class="pl-v">n</span>: <span class="pl-en">Node</span>)<span class="pl-k">:</span> <span class="pl-en">Option</span>[<span class="pl-en">Node</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L62" class="blob-num js-line-number" data-line-number="62"></td>
        <td id="LC62" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (e.n1 <span class="pl-k">==</span> n) <span class="pl-en">Some</span>(e.n2)</td>
      </tr>
      <tr>
        <td id="L63" class="blob-num js-line-number" data-line-number="63"></td>
        <td id="LC63" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> <span class="pl-k">if</span> (e.n2 <span class="pl-k">==</span> n) <span class="pl-en">Some</span>(e.n1)</td>
      </tr>
      <tr>
        <td id="L64" class="blob-num js-line-number" data-line-number="64"></td>
        <td id="LC64" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> <span class="pl-c1">None</span></td>
      </tr>
      <tr>
        <td id="L65" class="blob-num js-line-number" data-line-number="65"></td>
        <td id="LC65" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L66" class="blob-num js-line-number" data-line-number="66"></td>
        <td id="LC66" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addEdge</span>(<span class="pl-v">n1</span>: <span class="pl-en">T</span>, <span class="pl-v">n2</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span> addEdge(n1, n2, <span class="pl-k">new</span> <span class="pl-en">Edge</span>(nodes(n1), nodes(n2), <span class="pl-c1">None</span>))</td>
      </tr>
      <tr>
        <td id="L67" class="blob-num js-line-number" data-line-number="67"></td>
        <td id="LC67" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addEdge</span>(<span class="pl-v">n1</span>: <span class="pl-en">T</span>, <span class="pl-v">n2</span>: <span class="pl-en">T</span>, <span class="pl-v">value</span>: <span class="pl-en">U</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span> addEdge(n1, n2, <span class="pl-k">new</span> <span class="pl-en">Edge</span>(nodes(n1), nodes(n2), <span class="pl-en">Some</span>(value)))</td>
      </tr>
      <tr>
        <td id="L68" class="blob-num js-line-number" data-line-number="68"></td>
        <td id="LC68" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L69" class="blob-num js-line-number" data-line-number="69"></td>
        <td id="LC69" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">private</span>[<span class="pl-v">this</span>] <span class="pl-k">def</span> <span class="pl-en">addEdge</span>(<span class="pl-v">n1</span>: <span class="pl-en">T</span>, <span class="pl-v">n2</span>: <span class="pl-en">T</span>, <span class="pl-v">e</span>: <span class="pl-en">Edge</span>) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L70" class="blob-num js-line-number" data-line-number="70"></td>
        <td id="LC70" class="blob-code blob-code-inner js-file-line">      edges <span class="pl-k">=</span> e <span class="pl-k">::</span> edges</td>
      </tr>
      <tr>
        <td id="L71" class="blob-num js-line-number" data-line-number="71"></td>
        <td id="LC71" class="blob-code blob-code-inner js-file-line">      nodes(n1).adj <span class="pl-k">=</span> e <span class="pl-k">::</span> nodes(n1).adj</td>
      </tr>
      <tr>
        <td id="L72" class="blob-num js-line-number" data-line-number="72"></td>
        <td id="LC72" class="blob-code blob-code-inner js-file-line">      nodes(n2).adj <span class="pl-k">=</span> e <span class="pl-k">::</span> nodes(n2).adj</td>
      </tr>
      <tr>
        <td id="L73" class="blob-num js-line-number" data-line-number="73"></td>
        <td id="LC73" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L74" class="blob-num js-line-number" data-line-number="74"></td>
        <td id="LC74" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L75" class="blob-num js-line-number" data-line-number="75"></td>
        <td id="LC75" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L76" class="blob-num js-line-number" data-line-number="76"></td>
        <td id="LC76" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">fromEdges</span> <span class="pl-k">=</span> edges map {</td>
      </tr>
      <tr>
        <td id="L77" class="blob-num js-line-number" data-line-number="77"></td>
        <td id="LC77" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, <span class="pl-c1">None</span>) <span class="pl-k">=&gt;</span> n1.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>-<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> n2.value.toString</td>
      </tr>
      <tr>
        <td id="L78" class="blob-num js-line-number" data-line-number="78"></td>
        <td id="LC78" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, <span class="pl-en">Some</span>(value)) <span class="pl-k">=&gt;</span> n1.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>-<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> n2.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>/<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> value.toString</td>
      </tr>
      <tr>
        <td id="L79" class="blob-num js-line-number" data-line-number="79"></td>
        <td id="LC79" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L80" class="blob-num js-line-number" data-line-number="80"></td>
        <td id="LC80" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L81" class="blob-num js-line-number" data-line-number="81"></td>
        <td id="LC81" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">aloneNodes</span> <span class="pl-k">=</span> nodes.values.toList diff (edges flatMap { <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, _) <span class="pl-k">=&gt;</span> n1 <span class="pl-k">::</span> n2 <span class="pl-k">::</span> <span class="pl-c1">Nil</span> }) map {</td>
      </tr>
      <tr>
        <td id="L82" class="blob-num js-line-number" data-line-number="82"></td>
        <td id="LC82" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Node</span>(value) <span class="pl-k">=&gt;</span> value.toString</td>
      </tr>
      <tr>
        <td id="L83" class="blob-num js-line-number" data-line-number="83"></td>
        <td id="LC83" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L84" class="blob-num js-line-number" data-line-number="84"></td>
        <td id="LC84" class="blob-code blob-code-inner js-file-line">      (fromEdges <span class="pl-k">:::</span> aloneNodes).mkString(<span class="pl-s"><span class="pl-pds">&quot;</span>[<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>, <span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>]<span class="pl-pds">&quot;</span></span>)}</td>
      </tr>
      <tr>
        <td id="L85" class="blob-num js-line-number" data-line-number="85"></td>
        <td id="LC85" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L86" class="blob-num js-line-number" data-line-number="86"></td>
        <td id="LC86" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L87" class="blob-num js-line-number" data-line-number="87"></td>
        <td id="LC87" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">class</span> <span class="pl-en">Digraph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] <span class="pl-k">extends</span> <span class="pl-e">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] {</td>
      </tr>
      <tr>
        <td id="L88" class="blob-num js-line-number" data-line-number="88"></td>
        <td id="LC88" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">equals</span>(<span class="pl-v">o</span>: <span class="pl-en">Any</span>) <span class="pl-k">=</span> o <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L89" class="blob-num js-line-number" data-line-number="89"></td>
        <td id="LC89" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-v">g</span>: <span class="pl-en">Digraph</span>[<span class="pl-en">T</span>,<span class="pl-en">U</span>] <span class="pl-k">=&gt;</span> <span class="pl-v">super</span>.equals(g)</td>
      </tr>
      <tr>
        <td id="L90" class="blob-num js-line-number" data-line-number="90"></td>
        <td id="LC90" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L91" class="blob-num js-line-number" data-line-number="91"></td>
        <td id="LC91" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L92" class="blob-num js-line-number" data-line-number="92"></td>
        <td id="LC92" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L93" class="blob-num js-line-number" data-line-number="93"></td>
        <td id="LC93" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">edgeTarget</span>(<span class="pl-v">e</span>: <span class="pl-en">Edge</span>, <span class="pl-v">n</span>: <span class="pl-en">Node</span>)<span class="pl-k">:</span> <span class="pl-en">Option</span>[<span class="pl-en">Node</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L94" class="blob-num js-line-number" data-line-number="94"></td>
        <td id="LC94" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (e.n1 <span class="pl-k">==</span> n) <span class="pl-en">Some</span>(e.n2)</td>
      </tr>
      <tr>
        <td id="L95" class="blob-num js-line-number" data-line-number="95"></td>
        <td id="LC95" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> <span class="pl-c1">None</span></td>
      </tr>
      <tr>
        <td id="L96" class="blob-num js-line-number" data-line-number="96"></td>
        <td id="LC96" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L97" class="blob-num js-line-number" data-line-number="97"></td>
        <td id="LC97" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addArc</span>(<span class="pl-v">source</span>: <span class="pl-en">T</span>, <span class="pl-v">dest</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span> addArc(source, dest, <span class="pl-c1">None</span>)</td>
      </tr>
      <tr>
        <td id="L98" class="blob-num js-line-number" data-line-number="98"></td>
        <td id="LC98" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addArc</span>(<span class="pl-v">source</span>: <span class="pl-en">T</span>, <span class="pl-v">dest</span>: <span class="pl-en">T</span>, <span class="pl-v">value</span>: <span class="pl-en">U</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span> addArc(source, dest, <span class="pl-en">Some</span>(value))</td>
      </tr>
      <tr>
        <td id="L99" class="blob-num js-line-number" data-line-number="99"></td>
        <td id="LC99" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L100" class="blob-num js-line-number" data-line-number="100"></td>
        <td id="LC100" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">private</span>[<span class="pl-v">this</span>] <span class="pl-k">def</span> <span class="pl-en">addArc</span>(<span class="pl-v">source</span>: <span class="pl-en">T</span>, <span class="pl-v">dest</span>: <span class="pl-en">T</span>, <span class="pl-v">value</span>: <span class="pl-en">Option</span>[<span class="pl-en">U</span>]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L101" class="blob-num js-line-number" data-line-number="101"></td>
        <td id="LC101" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">e</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Edge</span>(nodes(source), nodes(dest), value)</td>
      </tr>
      <tr>
        <td id="L102" class="blob-num js-line-number" data-line-number="102"></td>
        <td id="LC102" class="blob-code blob-code-inner js-file-line">      edges <span class="pl-k">=</span> e <span class="pl-k">::</span> edges</td>
      </tr>
      <tr>
        <td id="L103" class="blob-num js-line-number" data-line-number="103"></td>
        <td id="LC103" class="blob-code blob-code-inner js-file-line">      nodes(source).adj <span class="pl-k">=</span> e <span class="pl-k">::</span> nodes(source).adj</td>
      </tr>
      <tr>
        <td id="L104" class="blob-num js-line-number" data-line-number="104"></td>
        <td id="LC104" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L105" class="blob-num js-line-number" data-line-number="105"></td>
        <td id="LC105" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L106" class="blob-num js-line-number" data-line-number="106"></td>
        <td id="LC106" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L107" class="blob-num js-line-number" data-line-number="107"></td>
        <td id="LC107" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">fromEdges</span> <span class="pl-k">=</span> edges map {</td>
      </tr>
      <tr>
        <td id="L108" class="blob-num js-line-number" data-line-number="108"></td>
        <td id="LC108" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, <span class="pl-c1">None</span>) <span class="pl-k">=&gt;</span> n1.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>&gt;<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> n2.value.toString</td>
      </tr>
      <tr>
        <td id="L109" class="blob-num js-line-number" data-line-number="109"></td>
        <td id="LC109" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, <span class="pl-en">Some</span>(value)) <span class="pl-k">=&gt;</span> n1.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>&gt;<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> n2.value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>/<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> value.toString</td>
      </tr>
      <tr>
        <td id="L110" class="blob-num js-line-number" data-line-number="110"></td>
        <td id="LC110" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L111" class="blob-num js-line-number" data-line-number="111"></td>
        <td id="LC111" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L112" class="blob-num js-line-number" data-line-number="112"></td>
        <td id="LC112" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">aloneNodes</span> <span class="pl-k">=</span> nodes.values.toList diff (edges flatMap { <span class="pl-k">case</span> <span class="pl-en">Edge</span>(n1, n2, _) <span class="pl-k">=&gt;</span> n1 <span class="pl-k">::</span> n2 <span class="pl-k">::</span> <span class="pl-c1">Nil</span> }) map {</td>
      </tr>
      <tr>
        <td id="L113" class="blob-num js-line-number" data-line-number="113"></td>
        <td id="LC113" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Node</span>(value) <span class="pl-k">=&gt;</span> value.toString</td>
      </tr>
      <tr>
        <td id="L114" class="blob-num js-line-number" data-line-number="114"></td>
        <td id="LC114" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L115" class="blob-num js-line-number" data-line-number="115"></td>
        <td id="LC115" class="blob-code blob-code-inner js-file-line">      (fromEdges <span class="pl-k">:::</span> aloneNodes).mkString(<span class="pl-s"><span class="pl-pds">&quot;</span>[<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>, <span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>]<span class="pl-pds">&quot;</span></span>)}</td>
      </tr>
      <tr>
        <td id="L116" class="blob-num js-line-number" data-line-number="116"></td>
        <td id="LC116" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L117" class="blob-num js-line-number" data-line-number="117"></td>
        <td id="LC117" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L118" class="blob-num js-line-number" data-line-number="118"></td>
        <td id="LC118" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>Implicits<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L119" class="blob-num js-line-number" data-line-number="119"></td>
        <td id="LC119" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">object</span> <span class="pl-en">Graph</span> {</td>
      </tr>
      <tr>
        <td id="L120" class="blob-num js-line-number" data-line-number="120"></td>
        <td id="LC120" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">term</span>[<span class="pl-en">T</span>](<span class="pl-v">nodes</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>], <span class="pl-v">edges</span>: <span class="pl-en">List</span>[(<span class="pl-en">T</span>, <span class="pl-en">T</span>)])<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-k">Unit</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L121" class="blob-num js-line-number" data-line-number="121"></td>
        <td id="LC121" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">graph</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-k">Unit</span>]</td>
      </tr>
      <tr>
        <td id="L122" class="blob-num js-line-number" data-line-number="122"></td>
        <td id="LC122" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> (node <span class="pl-k">&lt;</span><span class="pl-k">-</span> nodes) graph.addNode(node)</td>
      </tr>
      <tr>
        <td id="L123" class="blob-num js-line-number" data-line-number="123"></td>
        <td id="LC123" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> ((from, to) <span class="pl-k">&lt;</span><span class="pl-k">-</span> edges) graph.addEdge(from, to)</td>
      </tr>
      <tr>
        <td id="L124" class="blob-num js-line-number" data-line-number="124"></td>
        <td id="LC124" class="blob-code blob-code-inner js-file-line">      graph</td>
      </tr>
      <tr>
        <td id="L125" class="blob-num js-line-number" data-line-number="125"></td>
        <td id="LC125" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L126" class="blob-num js-line-number" data-line-number="126"></td>
        <td id="LC126" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L127" class="blob-num js-line-number" data-line-number="127"></td>
        <td id="LC127" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">nodes</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>], <span class="pl-v">edges</span>: <span class="pl-en">List</span>[(<span class="pl-en">T</span>, <span class="pl-en">T</span>, <span class="pl-en">Option</span>[<span class="pl-en">U</span>])])<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L128" class="blob-num js-line-number" data-line-number="128"></td>
        <td id="LC128" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">graph</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]()</td>
      </tr>
      <tr>
        <td id="L129" class="blob-num js-line-number" data-line-number="129"></td>
        <td id="LC129" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> (nodeValue <span class="pl-k">&lt;</span><span class="pl-k">-</span> nodes) graph.addNode(nodeValue)</td>
      </tr>
      <tr>
        <td id="L130" class="blob-num js-line-number" data-line-number="130"></td>
        <td id="LC130" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L131" class="blob-num js-line-number" data-line-number="131"></td>
        <td id="LC131" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> ((n1, n2, value) <span class="pl-k">&lt;</span><span class="pl-k">-</span> edges) value <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L132" class="blob-num js-line-number" data-line-number="132"></td>
        <td id="LC132" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Some</span>(edgeValue) <span class="pl-k">=&gt;</span> graph.addEdge(n1, n2, edgeValue)</td>
      </tr>
      <tr>
        <td id="L133" class="blob-num js-line-number" data-line-number="133"></td>
        <td id="LC133" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-c1">None</span> <span class="pl-k">=&gt;</span> graph.addEdge(n1, n2)</td>
      </tr>
      <tr>
        <td id="L134" class="blob-num js-line-number" data-line-number="134"></td>
        <td id="LC134" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L135" class="blob-num js-line-number" data-line-number="135"></td>
        <td id="LC135" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L136" class="blob-num js-line-number" data-line-number="136"></td>
        <td id="LC136" class="blob-code blob-code-inner js-file-line">      graph</td>
      </tr>
      <tr>
        <td id="L137" class="blob-num js-line-number" data-line-number="137"></td>
        <td id="LC137" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L138" class="blob-num js-line-number" data-line-number="138"></td>
        <td id="LC138" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L139" class="blob-num js-line-number" data-line-number="139"></td>
        <td id="LC139" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">termLabel</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">nodes</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>], <span class="pl-v">edges</span>: <span class="pl-en">List</span>[(<span class="pl-en">T</span>, <span class="pl-en">T</span>, <span class="pl-en">U</span>)])<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L140" class="blob-num js-line-number" data-line-number="140"></td>
        <td id="LC140" class="blob-code blob-code-inner js-file-line">      apply(nodes, edges map { <span class="pl-k">case</span> (n1, n2, v) <span class="pl-k">=&gt;</span> (n1, n2, <span class="pl-en">Some</span>(v))})</td>
      </tr>
      <tr>
        <td id="L141" class="blob-num js-line-number" data-line-number="141"></td>
        <td id="LC141" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L142" class="blob-num js-line-number" data-line-number="142"></td>
        <td id="LC142" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L143" class="blob-num js-line-number" data-line-number="143"></td>
        <td id="LC143" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">fromString</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>] <span class="pl-k">=</span> p80(str)</td>
      </tr>
      <tr>
        <td id="L144" class="blob-num js-line-number" data-line-number="144"></td>
        <td id="LC144" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">fromStringNum</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Int</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L145" class="blob-num js-line-number" data-line-number="145"></td>
        <td id="LC145" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">parsedGraph</span> <span class="pl-k">=</span> p80(str)</td>
      </tr>
      <tr>
        <td id="L146" class="blob-num js-line-number" data-line-number="146"></td>
        <td id="LC146" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">Graph</span>(parsedGraph.nodes.keys.toList, parsedGraph.edges map {</td>
      </tr>
      <tr>
        <td id="L147" class="blob-num js-line-number" data-line-number="147"></td>
        <td id="LC147" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> parsedGraph.<span class="pl-en">Edge</span>(parsedGraph.<span class="pl-en">Node</span>(n1), parsedGraph.<span class="pl-en">Node</span>(n2), <span class="pl-en">Some</span>(v)) <span class="pl-k">=&gt;</span> (n1, n2, <span class="pl-en">Some</span>(v.asDigit))</td>
      </tr>
      <tr>
        <td id="L148" class="blob-num js-line-number" data-line-number="148"></td>
        <td id="LC148" class="blob-code blob-code-inner js-file-line">      })</td>
      </tr>
      <tr>
        <td id="L149" class="blob-num js-line-number" data-line-number="149"></td>
        <td id="LC149" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L150" class="blob-num js-line-number" data-line-number="150"></td>
        <td id="LC150" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L151" class="blob-num js-line-number" data-line-number="151"></td>
        <td id="LC151" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L152" class="blob-num js-line-number" data-line-number="152"></td>
        <td id="LC152" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">object</span> <span class="pl-en">Digraph</span> {</td>
      </tr>
      <tr>
        <td id="L153" class="blob-num js-line-number" data-line-number="153"></td>
        <td id="LC153" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">fromString</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Digraph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>] <span class="pl-k">=</span> p80_2(str)</td>
      </tr>
      <tr>
        <td id="L154" class="blob-num js-line-number" data-line-number="154"></td>
        <td id="LC154" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">nodes</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>], <span class="pl-v">edges</span>: <span class="pl-en">List</span>[(<span class="pl-en">T</span>, <span class="pl-en">T</span>, <span class="pl-en">Option</span>[<span class="pl-en">U</span>])]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L155" class="blob-num js-line-number" data-line-number="155"></td>
        <td id="LC155" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">graph</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Digraph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]()</td>
      </tr>
      <tr>
        <td id="L156" class="blob-num js-line-number" data-line-number="156"></td>
        <td id="LC156" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> (nodeValue <span class="pl-k">&lt;</span><span class="pl-k">-</span> nodes) graph.addNode(nodeValue)</td>
      </tr>
      <tr>
        <td id="L157" class="blob-num js-line-number" data-line-number="157"></td>
        <td id="LC157" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L158" class="blob-num js-line-number" data-line-number="158"></td>
        <td id="LC158" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> ((n1, n2, value) <span class="pl-k">&lt;</span><span class="pl-k">-</span> edges) value <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L159" class="blob-num js-line-number" data-line-number="159"></td>
        <td id="LC159" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-en">Some</span>(edgeValue) <span class="pl-k">=&gt;</span> graph.addArc(n1, n2, edgeValue)</td>
      </tr>
      <tr>
        <td id="L160" class="blob-num js-line-number" data-line-number="160"></td>
        <td id="LC160" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-c1">None</span> <span class="pl-k">=&gt;</span> graph.addArc(n1, n2)</td>
      </tr>
      <tr>
        <td id="L161" class="blob-num js-line-number" data-line-number="161"></td>
        <td id="LC161" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L162" class="blob-num js-line-number" data-line-number="162"></td>
        <td id="LC162" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L163" class="blob-num js-line-number" data-line-number="163"></td>
        <td id="LC163" class="blob-code blob-code-inner js-file-line">      graph</td>
      </tr>
      <tr>
        <td id="L164" class="blob-num js-line-number" data-line-number="164"></td>
        <td id="LC164" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L165" class="blob-num js-line-number" data-line-number="165"></td>
        <td id="LC165" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L166" class="blob-num js-line-number" data-line-number="166"></td>
        <td id="LC166" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L167" class="blob-num js-line-number" data-line-number="167"></td>
        <td id="LC167" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">GraphExt</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">gr</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]){</td>
      </tr>
      <tr>
        <td id="L168" class="blob-num js-line-number" data-line-number="168"></td>
        <td id="LC168" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L169" class="blob-num js-line-number" data-line-number="169"></td>
        <td id="LC169" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L170" class="blob-num js-line-number" data-line-number="170"></td>
        <td id="LC170" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">DigraphExt</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">gr</span>: <span class="pl-en">Digraph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]){</td>
      </tr>
      <tr>
        <td id="L171" class="blob-num js-line-number" data-line-number="171"></td>
        <td id="LC171" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L172" class="blob-num js-line-number" data-line-number="172"></td>
        <td id="LC172" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L173" class="blob-num js-line-number" data-line-number="173"></td>
        <td id="LC173" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">GraphBaseExt</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">gr</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]) {</td>
      </tr>
      <tr>
        <td id="L174" class="blob-num js-line-number" data-line-number="174"></td>
        <td id="LC174" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">addNodeIfMissing</span>(<span class="pl-v">value</span>: <span class="pl-en">T</span>) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L175" class="blob-num js-line-number" data-line-number="175"></td>
        <td id="LC175" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (<span class="pl-k">!</span>gr.nodes.contains(value)) {</td>
      </tr>
      <tr>
        <td id="L176" class="blob-num js-line-number" data-line-number="176"></td>
        <td id="LC176" class="blob-code blob-code-inner js-file-line">        gr.addNode(value)</td>
      </tr>
      <tr>
        <td id="L177" class="blob-num js-line-number" data-line-number="177"></td>
        <td id="LC177" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L178" class="blob-num js-line-number" data-line-number="178"></td>
        <td id="LC178" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L179" class="blob-num js-line-number" data-line-number="179"></td>
        <td id="LC179" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L180" class="blob-num js-line-number" data-line-number="180"></td>
        <td id="LC180" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">toTermForm</span> <span class="pl-k">=</span> gr.nodes.keys.toList <span class="pl-k">-</span><span class="pl-k">&gt;</span> (gr.edges map { <span class="pl-k">case</span> gr.<span class="pl-en">Edge</span>(n1, n2, value) <span class="pl-k">=&gt;</span> (n1.value, n2.value, value) })</td>
      </tr>
      <tr>
        <td id="L181" class="blob-num js-line-number" data-line-number="181"></td>
        <td id="LC181" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L182" class="blob-num js-line-number" data-line-number="182"></td>
        <td id="LC182" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">toAdjacentForm</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L183" class="blob-num js-line-number" data-line-number="183"></td>
        <td id="LC183" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">edges</span> <span class="pl-k">=</span> (<span class="pl-k">for</span> (node <span class="pl-k">&lt;</span><span class="pl-k">-</span> gr.nodes.values;</td>
      </tr>
      <tr>
        <td id="L184" class="blob-num js-line-number" data-line-number="184"></td>
        <td id="LC184" class="blob-code blob-code-inner js-file-line">                       edge <span class="pl-k">&lt;</span><span class="pl-k">-</span> gr.edges</td>
      </tr>
      <tr>
        <td id="L185" class="blob-num js-line-number" data-line-number="185"></td>
        <td id="LC185" class="blob-code blob-code-inner js-file-line">                       <span class="pl-k">if</span> edge.n1 <span class="pl-k">==</span> node) <span class="pl-k">yield</span> node.value <span class="pl-k">-</span><span class="pl-k">&gt;</span> (edge.n2, edge.value)</td>
      </tr>
      <tr>
        <td id="L186" class="blob-num js-line-number" data-line-number="186"></td>
        <td id="LC186" class="blob-code blob-code-inner js-file-line">                   ) groupBy { _._1 } mapValues { <span class="pl-k">case</span> x <span class="pl-k">=&gt;</span> x.map {</td>
      </tr>
      <tr>
        <td id="L187" class="blob-num js-line-number" data-line-number="187"></td>
        <td id="LC187" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (k, (gr.<span class="pl-en">Node</span>(value), <span class="pl-en">Some</span>(v))) <span class="pl-k">=&gt;</span> (value.toString, v.toString)</td>
      </tr>
      <tr>
        <td id="L188" class="blob-num js-line-number" data-line-number="188"></td>
        <td id="LC188" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (k, (gr.<span class="pl-en">Node</span>(value), <span class="pl-c1">None</span>)) <span class="pl-k">=&gt;</span> (value.toString, <span class="pl-s"><span class="pl-pds">&quot;</span>?<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L189" class="blob-num js-line-number" data-line-number="189"></td>
        <td id="LC189" class="blob-code blob-code-inner js-file-line">        }.toList</td>
      </tr>
      <tr>
        <td id="L190" class="blob-num js-line-number" data-line-number="190"></td>
        <td id="LC190" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L191" class="blob-num js-line-number" data-line-number="191"></td>
        <td id="LC191" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L192" class="blob-num js-line-number" data-line-number="192"></td>
        <td id="LC192" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">loneNodes</span> <span class="pl-k">=</span> (gr.nodes.values</td>
      </tr>
      <tr>
        <td id="L193" class="blob-num js-line-number" data-line-number="193"></td>
        <td id="LC193" class="blob-code blob-code-inner js-file-line">        filter { node <span class="pl-k">=&gt;</span> gr.edges.forall(x <span class="pl-k">=&gt;</span> x.n1 <span class="pl-k">!=</span> node)}</td>
      </tr>
      <tr>
        <td id="L194" class="blob-num js-line-number" data-line-number="194"></td>
        <td id="LC194" class="blob-code blob-code-inner js-file-line">        map  { node <span class="pl-k">=&gt;</span> (node.value, <span class="pl-en">List</span>.empty) })</td>
      </tr>
      <tr>
        <td id="L195" class="blob-num js-line-number" data-line-number="195"></td>
        <td id="LC195" class="blob-code blob-code-inner js-file-line">      edges.toList <span class="pl-k">:::</span> loneNodes.toList</td>
      </tr>
      <tr>
        <td id="L196" class="blob-num js-line-number" data-line-number="196"></td>
        <td id="LC196" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L197" class="blob-num js-line-number" data-line-number="197"></td>
        <td id="LC197" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L198" class="blob-num js-line-number" data-line-number="198"></td>
        <td id="LC198" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">findPaths</span>(<span class="pl-v">from</span>: <span class="pl-en">T</span>, <span class="pl-v">to</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span><span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> p81(gr, from, to)</td>
      </tr>
      <tr>
        <td id="L199" class="blob-num js-line-number" data-line-number="199"></td>
        <td id="LC199" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L200" class="blob-num js-line-number" data-line-number="200"></td>
        <td id="LC200" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L201" class="blob-num js-line-number" data-line-number="201"></td>
        <td id="LC201" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P80. Conversions.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L202" class="blob-num js-line-number" data-line-number="202"></td>
        <td id="LC202" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L203" class="blob-num js-line-number" data-line-number="203"></td>
        <td id="LC203" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p80</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L204" class="blob-num js-line-number" data-line-number="204"></td>
        <td id="LC204" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">graph</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>]</td>
      </tr>
      <tr>
        <td id="L205" class="blob-num js-line-number" data-line-number="205"></td>
        <td id="LC205" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">edgeMap</span> <span class="pl-k">=</span> str.drop(<span class="pl-c1">1</span>).dropRight(<span class="pl-c1">1</span>).split(<span class="pl-s"><span class="pl-pds">&quot;</span>, <span class="pl-pds">&quot;</span></span>) map {_.toList}</td>
      </tr>
      <tr>
        <td id="L206" class="blob-num js-line-number" data-line-number="206"></td>
        <td id="LC206" class="blob-code blob-code-inner js-file-line">    edgeMap map {</td>
      </tr>
      <tr>
        <td id="L207" class="blob-num js-line-number" data-line-number="207"></td>
        <td id="LC207" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;-&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L208" class="blob-num js-line-number" data-line-number="208"></td>
        <td id="LC208" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L209" class="blob-num js-line-number" data-line-number="209"></td>
        <td id="LC209" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L210" class="blob-num js-line-number" data-line-number="210"></td>
        <td id="LC210" class="blob-code blob-code-inner js-file-line">        graph.addEdge(from, to)</td>
      </tr>
      <tr>
        <td id="L211" class="blob-num js-line-number" data-line-number="211"></td>
        <td id="LC211" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;-&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">&#39;/&#39;</span> <span class="pl-k">::</span> value <span class="pl-k">::</span><span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L212" class="blob-num js-line-number" data-line-number="212"></td>
        <td id="LC212" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L213" class="blob-num js-line-number" data-line-number="213"></td>
        <td id="LC213" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L214" class="blob-num js-line-number" data-line-number="214"></td>
        <td id="LC214" class="blob-code blob-code-inner js-file-line">        graph.addEdge(from, to, value)</td>
      </tr>
      <tr>
        <td id="L215" class="blob-num js-line-number" data-line-number="215"></td>
        <td id="LC215" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> node <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> graph.addNodeIfMissing(node)</td>
      </tr>
      <tr>
        <td id="L216" class="blob-num js-line-number" data-line-number="216"></td>
        <td id="LC216" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L217" class="blob-num js-line-number" data-line-number="217"></td>
        <td id="LC217" class="blob-code blob-code-inner js-file-line">    graph</td>
      </tr>
      <tr>
        <td id="L218" class="blob-num js-line-number" data-line-number="218"></td>
        <td id="LC218" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L219" class="blob-num js-line-number" data-line-number="219"></td>
        <td id="LC219" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L220" class="blob-num js-line-number" data-line-number="220"></td>
        <td id="LC220" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p80_2</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">Digraph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L221" class="blob-num js-line-number" data-line-number="221"></td>
        <td id="LC221" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">graph</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">Digraph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>]</td>
      </tr>
      <tr>
        <td id="L222" class="blob-num js-line-number" data-line-number="222"></td>
        <td id="LC222" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">edgeMap</span> <span class="pl-k">=</span> str.drop(<span class="pl-c1">1</span>).dropRight(<span class="pl-c1">1</span>).split(<span class="pl-s"><span class="pl-pds">&quot;</span>, <span class="pl-pds">&quot;</span></span>) map {_.toList}</td>
      </tr>
      <tr>
        <td id="L223" class="blob-num js-line-number" data-line-number="223"></td>
        <td id="LC223" class="blob-code blob-code-inner js-file-line">    edgeMap map {</td>
      </tr>
      <tr>
        <td id="L224" class="blob-num js-line-number" data-line-number="224"></td>
        <td id="LC224" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;&gt;&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L225" class="blob-num js-line-number" data-line-number="225"></td>
        <td id="LC225" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L226" class="blob-num js-line-number" data-line-number="226"></td>
        <td id="LC226" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L227" class="blob-num js-line-number" data-line-number="227"></td>
        <td id="LC227" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to)</td>
      </tr>
      <tr>
        <td id="L228" class="blob-num js-line-number" data-line-number="228"></td>
        <td id="LC228" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;&gt;&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">&#39;/&#39;</span> <span class="pl-k">::</span> value <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L229" class="blob-num js-line-number" data-line-number="229"></td>
        <td id="LC229" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L230" class="blob-num js-line-number" data-line-number="230"></td>
        <td id="LC230" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L231" class="blob-num js-line-number" data-line-number="231"></td>
        <td id="LC231" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to, value)</td>
      </tr>
      <tr>
        <td id="L232" class="blob-num js-line-number" data-line-number="232"></td>
        <td id="LC232" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> to <span class="pl-k">::</span> <span class="pl-c1">&#39;&lt;&#39;</span> <span class="pl-k">::</span> from <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L233" class="blob-num js-line-number" data-line-number="233"></td>
        <td id="LC233" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L234" class="blob-num js-line-number" data-line-number="234"></td>
        <td id="LC234" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L235" class="blob-num js-line-number" data-line-number="235"></td>
        <td id="LC235" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to)</td>
      </tr>
      <tr>
        <td id="L236" class="blob-num js-line-number" data-line-number="236"></td>
        <td id="LC236" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> to <span class="pl-k">::</span> <span class="pl-c1">&#39;&lt;&#39;</span> <span class="pl-k">::</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;/&#39;</span> <span class="pl-k">::</span> value <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L237" class="blob-num js-line-number" data-line-number="237"></td>
        <td id="LC237" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L238" class="blob-num js-line-number" data-line-number="238"></td>
        <td id="LC238" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L239" class="blob-num js-line-number" data-line-number="239"></td>
        <td id="LC239" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to, value)</td>
      </tr>
      <tr>
        <td id="L240" class="blob-num js-line-number" data-line-number="240"></td>
        <td id="LC240" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;-&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L241" class="blob-num js-line-number" data-line-number="241"></td>
        <td id="LC241" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L242" class="blob-num js-line-number" data-line-number="242"></td>
        <td id="LC242" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L243" class="blob-num js-line-number" data-line-number="243"></td>
        <td id="LC243" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to)</td>
      </tr>
      <tr>
        <td id="L244" class="blob-num js-line-number" data-line-number="244"></td>
        <td id="LC244" class="blob-code blob-code-inner js-file-line">        graph.addArc(to, from)</td>
      </tr>
      <tr>
        <td id="L245" class="blob-num js-line-number" data-line-number="245"></td>
        <td id="LC245" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> from <span class="pl-k">::</span> <span class="pl-c1">&#39;-&#39;</span> <span class="pl-k">::</span> to <span class="pl-k">::</span> <span class="pl-c1">&#39;/&#39;</span> <span class="pl-k">::</span> value <span class="pl-k">::</span><span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L246" class="blob-num js-line-number" data-line-number="246"></td>
        <td id="LC246" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(from)</td>
      </tr>
      <tr>
        <td id="L247" class="blob-num js-line-number" data-line-number="247"></td>
        <td id="LC247" class="blob-code blob-code-inner js-file-line">        graph.addNodeIfMissing(to)</td>
      </tr>
      <tr>
        <td id="L248" class="blob-num js-line-number" data-line-number="248"></td>
        <td id="LC248" class="blob-code blob-code-inner js-file-line">        graph.addArc(from, to, value)</td>
      </tr>
      <tr>
        <td id="L249" class="blob-num js-line-number" data-line-number="249"></td>
        <td id="LC249" class="blob-code blob-code-inner js-file-line">        graph.addArc(to, from, value)</td>
      </tr>
      <tr>
        <td id="L250" class="blob-num js-line-number" data-line-number="250"></td>
        <td id="LC250" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> node <span class="pl-k">::</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> graph.addNodeIfMissing(node)</td>
      </tr>
      <tr>
        <td id="L251" class="blob-num js-line-number" data-line-number="251"></td>
        <td id="LC251" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L252" class="blob-num js-line-number" data-line-number="252"></td>
        <td id="LC252" class="blob-code blob-code-inner js-file-line">    graph</td>
      </tr>
      <tr>
        <td id="L253" class="blob-num js-line-number" data-line-number="253"></td>
        <td id="LC253" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L254" class="blob-num js-line-number" data-line-number="254"></td>
        <td id="LC254" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L255" class="blob-num js-line-number" data-line-number="255"></td>
        <td id="LC255" class="blob-code blob-code-inner js-file-line">  out(p80(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c, f-c, g-h, d, f-b, k-f, h-g]<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>[h-g, k-f, f-b, g-h, f-c, b-c, d]<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L256" class="blob-num js-line-number" data-line-number="256"></td>
        <td id="LC256" class="blob-code blob-code-inner js-file-line">  out(p80_2(<span class="pl-s"><span class="pl-pds">&quot;</span>[b&gt;c, f&gt;c, g&gt;h, d, f&lt;b, k&lt;f, h&lt;g]<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>[g&gt;h, f&gt;k, b&gt;f, g&gt;h, f&gt;c, b&gt;c, d]<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L257" class="blob-num js-line-number" data-line-number="257"></td>
        <td id="LC257" class="blob-code blob-code-inner js-file-line">  out(p80(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c/e, f-c/1, g-h/2, d, f-b/3, k-f, h-g]<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>[h-g, k-f, f-b/3, g-h/2, f-c/1, b-c/e, d]<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L258" class="blob-num js-line-number" data-line-number="258"></td>
        <td id="LC258" class="blob-code blob-code-inner js-file-line">  out(p80_2(<span class="pl-s"><span class="pl-pds">&quot;</span>[b&gt;c/1, f&gt;c/e, g&gt;h/2, d, f&lt;b, k&lt;f, h&lt;g/8]<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>[g&gt;h/8, f&gt;k, b&gt;f, g&gt;h/2, f&gt;c/e, b&gt;c/1, d]<span class="pl-pds">&quot;</span></span>         <span class="pl-c">// Notice g&gt;h twice, once labeled 2, the other one - 8</span></td>
      </tr>
      <tr>
        <td id="L259" class="blob-num js-line-number" data-line-number="259"></td>
        <td id="LC259" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L260" class="blob-num js-line-number" data-line-number="260"></td>
        <td id="LC260" class="blob-code blob-code-inner js-file-line">  out(p80(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c, f-c, g-h, d, f-b, k-f, h-g]<span class="pl-pds">&quot;</span></span>).toTermForm)</td>
      </tr>
      <tr>
        <td id="L261" class="blob-num js-line-number" data-line-number="261"></td>
        <td id="LC261" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">Digraph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[p&gt;q/9, m&gt;q/7, k, p&gt;m/5]<span class="pl-pds">&quot;</span></span>).toAdjacentForm)</td>
      </tr>
      <tr>
        <td id="L262" class="blob-num js-line-number" data-line-number="262"></td>
        <td id="LC262" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L263" class="blob-num js-line-number" data-line-number="263"></td>
        <td id="LC263" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P81. Path from one node to another one<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L264" class="blob-num js-line-number" data-line-number="264"></td>
        <td id="LC264" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p81</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">graph</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>], <span class="pl-v">from</span>: <span class="pl-en">T</span>, <span class="pl-v">to</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L265" class="blob-num js-line-number" data-line-number="265"></td>
        <td id="LC265" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">node</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">visited</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L266" class="blob-num js-line-number" data-line-number="266"></td>
        <td id="LC266" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">nodesToGoTo</span> <span class="pl-k">=</span> graph.edges collect {</td>
      </tr>
      <tr>
        <td id="L267" class="blob-num js-line-number" data-line-number="267"></td>
        <td id="LC267" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(`node`, <span class="pl-v">to</span> : graph.<span class="pl-en">Node</span>, value) <span class="pl-k">if</span> <span class="pl-k">!</span>visited.contains(node) <span class="pl-k">=&gt;</span> to</td>
      </tr>
      <tr>
        <td id="L268" class="blob-num js-line-number" data-line-number="268"></td>
        <td id="LC268" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L269" class="blob-num js-line-number" data-line-number="269"></td>
        <td id="LC269" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L270" class="blob-num js-line-number" data-line-number="270"></td>
        <td id="LC270" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">finishList</span> <span class="pl-k">=</span> nodesToGoTo collect {</td>
      </tr>
      <tr>
        <td id="L271" class="blob-num js-line-number" data-line-number="271"></td>
        <td id="LC271" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> graph.<span class="pl-en">Node</span>(value) <span class="pl-k">if</span> value <span class="pl-k">==</span> to <span class="pl-k">=&gt;</span> node.value <span class="pl-k">::</span> value <span class="pl-k">::</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L272" class="blob-num js-line-number" data-line-number="272"></td>
        <td id="LC272" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L273" class="blob-num js-line-number" data-line-number="273"></td>
        <td id="LC273" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L274" class="blob-num js-line-number" data-line-number="274"></td>
        <td id="LC274" class="blob-code blob-code-inner js-file-line">      finishList <span class="pl-k">:::</span> (nodesToGoTo filter {</td>
      </tr>
      <tr>
        <td id="L275" class="blob-num js-line-number" data-line-number="275"></td>
        <td id="LC275" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> graph.<span class="pl-en">Node</span>(value) <span class="pl-k">=&gt;</span> value <span class="pl-k">!=</span> to</td>
      </tr>
      <tr>
        <td id="L276" class="blob-num js-line-number" data-line-number="276"></td>
        <td id="LC276" class="blob-code blob-code-inner js-file-line">        } flatMap { x <span class="pl-k">=&gt;</span> inner(x, visited <span class="pl-k">+</span> node)</td>
      </tr>
      <tr>
        <td id="L277" class="blob-num js-line-number" data-line-number="277"></td>
        <td id="LC277" class="blob-code blob-code-inner js-file-line">        } map { x <span class="pl-k">=&gt;</span> node.value <span class="pl-k">::</span> x })</td>
      </tr>
      <tr>
        <td id="L278" class="blob-num js-line-number" data-line-number="278"></td>
        <td id="LC278" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L279" class="blob-num js-line-number" data-line-number="279"></td>
        <td id="LC279" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L280" class="blob-num js-line-number" data-line-number="280"></td>
        <td id="LC280" class="blob-code blob-code-inner js-file-line">    inner(graph.nodes(from), <span class="pl-en">Set</span>.empty)</td>
      </tr>
      <tr>
        <td id="L281" class="blob-num js-line-number" data-line-number="281"></td>
        <td id="LC281" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L282" class="blob-num js-line-number" data-line-number="282"></td>
        <td id="LC282" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L283" class="blob-num js-line-number" data-line-number="283"></td>
        <td id="LC283" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p81_2</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">graph</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>], <span class="pl-v">from</span>: <span class="pl-en">T</span>, <span class="pl-v">to</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L284" class="blob-num js-line-number" data-line-number="284"></td>
        <td id="LC284" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">findPathsR</span>(<span class="pl-v">curNode</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">curPath</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L285" class="blob-num js-line-number" data-line-number="285"></td>
        <td id="LC285" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (curNode.value <span class="pl-k">==</span> to) <span class="pl-en">List</span>(curPath)</td>
      </tr>
      <tr>
        <td id="L286" class="blob-num js-line-number" data-line-number="286"></td>
        <td id="LC286" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> curNode.adj.map(graph.edgeTarget(_, curNode).get).filter(n <span class="pl-k">=&gt;</span> <span class="pl-k">!</span>curPath.contains(n.value)).flatMap(n <span class="pl-k">=&gt;</span> findPathsR(n, n.value <span class="pl-k">::</span> curPath))</td>
      </tr>
      <tr>
        <td id="L287" class="blob-num js-line-number" data-line-number="287"></td>
        <td id="LC287" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L288" class="blob-num js-line-number" data-line-number="288"></td>
        <td id="LC288" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L289" class="blob-num js-line-number" data-line-number="289"></td>
        <td id="LC289" class="blob-code blob-code-inner js-file-line">    findPathsR(graph.nodes(from), <span class="pl-en">List</span>(from)).map(_.reverse)</td>
      </tr>
      <tr>
        <td id="L290" class="blob-num js-line-number" data-line-number="290"></td>
        <td id="LC290" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L291" class="blob-num js-line-number" data-line-number="291"></td>
        <td id="LC291" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L292" class="blob-num js-line-number" data-line-number="292"></td>
        <td id="LC292" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-en">Digraph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[p&gt;q/9, m&gt;q/7, k, p&gt;m/5]<span class="pl-pds">&quot;</span></span>).findPaths(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-en">List</span>(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>), <span class="pl-en">List</span>(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;m&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L293" class="blob-num js-line-number" data-line-number="293"></td>
        <td id="LC293" class="blob-code blob-code-inner js-file-line">  out(p81_2(<span class="pl-en">Digraph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[p&gt;q/9, m&gt;q/7, k, p&gt;m/5]<span class="pl-pds">&quot;</span></span>), <span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-en">List</span>(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;m&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>), <span class="pl-en">List</span>(<span class="pl-c1">&#39;p&#39;</span>, <span class="pl-c1">&#39;q&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L294" class="blob-num js-line-number" data-line-number="294"></td>
        <td id="LC294" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L295" class="blob-num js-line-number" data-line-number="295"></td>
        <td id="LC295" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P82. Cycle from a given node.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L296" class="blob-num js-line-number" data-line-number="296"></td>
        <td id="LC296" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p82</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">graph</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>], <span class="pl-v">target</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L297" class="blob-num js-line-number" data-line-number="297"></td>
        <td id="LC297" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">node</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">visited</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-en">T</span>]] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L298" class="blob-num js-line-number" data-line-number="298"></td>
        <td id="LC298" class="blob-code blob-code-inner js-file-line">      graph.edges filter {</td>
      </tr>
      <tr>
        <td id="L299" class="blob-num js-line-number" data-line-number="299"></td>
        <td id="LC299" class="blob-code blob-code-inner js-file-line">        x <span class="pl-k">=&gt;</span> <span class="pl-k">!</span>visited.contains(x)</td>
      </tr>
      <tr>
        <td id="L300" class="blob-num js-line-number" data-line-number="300"></td>
        <td id="LC300" class="blob-code blob-code-inner js-file-line">      } flatMap {</td>
      </tr>
      <tr>
        <td id="L301" class="blob-num js-line-number" data-line-number="301"></td>
        <td id="LC301" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(`node`, to, _) <span class="pl-k">if</span> to.value <span class="pl-k">==</span> target <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(<span class="pl-c1">Nil</span>)</td>
      </tr>
      <tr>
        <td id="L302" class="blob-num js-line-number" data-line-number="302"></td>
        <td id="LC302" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> edge<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(`node`, <span class="pl-v">to</span> : graph.<span class="pl-en">Node</span>, _) <span class="pl-k">=&gt;</span> inner(to, visited <span class="pl-k">+</span> edge)</td>
      </tr>
      <tr>
        <td id="L303" class="blob-num js-line-number" data-line-number="303"></td>
        <td id="LC303" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L304" class="blob-num js-line-number" data-line-number="304"></td>
        <td id="LC304" class="blob-code blob-code-inner js-file-line">      } map {</td>
      </tr>
      <tr>
        <td id="L305" class="blob-num js-line-number" data-line-number="305"></td>
        <td id="LC305" class="blob-code blob-code-inner js-file-line">        x <span class="pl-k">=&gt;</span> node.value <span class="pl-k">::</span> x</td>
      </tr>
      <tr>
        <td id="L306" class="blob-num js-line-number" data-line-number="306"></td>
        <td id="LC306" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L307" class="blob-num js-line-number" data-line-number="307"></td>
        <td id="LC307" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L308" class="blob-num js-line-number" data-line-number="308"></td>
        <td id="LC308" class="blob-code blob-code-inner js-file-line">    inner(graph.nodes(target), <span class="pl-en">Set</span>.empty) map { x <span class="pl-k">=&gt;</span> x <span class="pl-k">:::</span> (target <span class="pl-k">::</span> <span class="pl-c1">Nil</span>) }</td>
      </tr>
      <tr>
        <td id="L309" class="blob-num js-line-number" data-line-number="309"></td>
        <td id="LC309" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L310" class="blob-num js-line-number" data-line-number="310"></td>
        <td id="LC310" class="blob-code blob-code-inner js-file-line">  out(p82(<span class="pl-en">Digraph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[f&gt;a, a&gt;f, f&gt;b, b&gt;c, c&gt;d, d&gt;f, c&gt;f]<span class="pl-pds">&quot;</span></span>), <span class="pl-c1">&#39;f&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L311" class="blob-num js-line-number" data-line-number="311"></td>
        <td id="LC311" class="blob-code blob-code-inner js-file-line">  out(p82(<span class="pl-en">Digraph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[b&lt;c, f&gt;c, g-h, d, f&lt;b, k-f, h-g, f&gt;e, e&gt;g, g&gt;h, h&gt;f]<span class="pl-pds">&quot;</span></span>), <span class="pl-c1">&#39;f&#39;</span>))</td>
      </tr>
      <tr>
        <td id="L312" class="blob-num js-line-number" data-line-number="312"></td>
        <td id="LC312" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L313" class="blob-num js-line-number" data-line-number="313"></td>
        <td id="LC313" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P83. Construct all spanning trees.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L314" class="blob-num js-line-number" data-line-number="314"></td>
        <td id="LC314" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L315" class="blob-num js-line-number" data-line-number="315"></td>
        <td id="LC315" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">val</span> <span class="pl-en">tree</span> <span class="pl-k">=</span> <span class="pl-en">Graph</span>.term(<span class="pl-en">List</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>),</td>
      </tr>
      <tr>
        <td id="L316" class="blob-num js-line-number" data-line-number="316"></td>
        <td id="LC316" class="blob-code blob-code-inner js-file-line">    <span class="pl-en">List</span>((<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>), (<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>), (<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>), (<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>),</td>
      </tr>
      <tr>
        <td id="L317" class="blob-num js-line-number" data-line-number="317"></td>
        <td id="LC317" class="blob-code blob-code-inner js-file-line">      (<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>),</td>
      </tr>
      <tr>
        <td id="L318" class="blob-num js-line-number" data-line-number="318"></td>
        <td id="LC318" class="blob-code blob-code-inner js-file-line">      (<span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>), (<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>), (<span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>)))</td>
      </tr>
      <tr>
        <td id="L319" class="blob-num js-line-number" data-line-number="319"></td>
        <td id="LC319" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L320" class="blob-num js-line-number" data-line-number="320"></td>
        <td id="LC320" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">import</span> <span class="pl-v">scala.collection.</span><span class="pl-v">mutable</span></td>
      </tr>
      <tr>
        <td id="L321" class="blob-num js-line-number" data-line-number="321"></td>
        <td id="LC321" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p83</span>(<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L322" class="blob-num js-line-number" data-line-number="322"></td>
        <td id="LC322" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isGraphConnected</span>(<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L323" class="blob-num js-line-number" data-line-number="323"></td>
        <td id="LC323" class="blob-code blob-code-inner js-file-line">      <span class="pl-c">// BFS in OO style.</span></td>
      </tr>
      <tr>
        <td id="L324" class="blob-num js-line-number" data-line-number="324"></td>
        <td id="LC324" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">visitedNodes</span> <span class="pl-k">=</span> mutable.<span class="pl-en">Set</span>[graph.<span class="pl-en">Node</span>]()</td>
      </tr>
      <tr>
        <td id="L325" class="blob-num js-line-number" data-line-number="325"></td>
        <td id="LC325" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">visitedEdges</span> <span class="pl-k">=</span> mutable.<span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>]()</td>
      </tr>
      <tr>
        <td id="L326" class="blob-num js-line-number" data-line-number="326"></td>
        <td id="LC326" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">scheduled</span> <span class="pl-k">=</span> mutable.<span class="pl-en">Queue</span>[graph.<span class="pl-en">Node</span>]()</td>
      </tr>
      <tr>
        <td id="L327" class="blob-num js-line-number" data-line-number="327"></td>
        <td id="LC327" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> (_, startingNode) <span class="pl-k">=</span> graph.nodes.head</td>
      </tr>
      <tr>
        <td id="L328" class="blob-num js-line-number" data-line-number="328"></td>
        <td id="LC328" class="blob-code blob-code-inner js-file-line">      scheduled <span class="pl-k">+</span><span class="pl-k">=</span> startingNode</td>
      </tr>
      <tr>
        <td id="L329" class="blob-num js-line-number" data-line-number="329"></td>
        <td id="LC329" class="blob-code blob-code-inner js-file-line">      visitedNodes <span class="pl-k">+</span><span class="pl-k">=</span> startingNode</td>
      </tr>
      <tr>
        <td id="L330" class="blob-num js-line-number" data-line-number="330"></td>
        <td id="LC330" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> (elem <span class="pl-k">&lt;</span><span class="pl-k">-</span> scheduled){</td>
      </tr>
      <tr>
        <td id="L331" class="blob-num js-line-number" data-line-number="331"></td>
        <td id="LC331" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> <span class="pl-en">nodesToVisit</span> <span class="pl-k">=</span> graph.edges filter {<span class="pl-k">!</span>visitedEdges.contains(_)} collect {</td>
      </tr>
      <tr>
        <td id="L332" class="blob-num js-line-number" data-line-number="332"></td>
        <td id="LC332" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(`elem`, <span class="pl-v">n</span> : graph.<span class="pl-en">Node</span>, _) <span class="pl-k">=&gt;</span> { visitedEdges <span class="pl-k">+</span><span class="pl-k">=</span> e; n }</td>
      </tr>
      <tr>
        <td id="L333" class="blob-num js-line-number" data-line-number="333"></td>
        <td id="LC333" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(<span class="pl-v">n</span> : graph.<span class="pl-en">Node</span>, `elem`, _) <span class="pl-k">=&gt;</span> { visitedEdges <span class="pl-k">+</span><span class="pl-k">=</span> e; n }</td>
      </tr>
      <tr>
        <td id="L334" class="blob-num js-line-number" data-line-number="334"></td>
        <td id="LC334" class="blob-code blob-code-inner js-file-line">        }</td>
      </tr>
      <tr>
        <td id="L335" class="blob-num js-line-number" data-line-number="335"></td>
        <td id="LC335" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L336" class="blob-num js-line-number" data-line-number="336"></td>
        <td id="LC336" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">if</span> (nodesToVisit.exists(visitedNodes.contains(_))) {</td>
      </tr>
      <tr>
        <td id="L337" class="blob-num js-line-number" data-line-number="337"></td>
        <td id="LC337" class="blob-code blob-code-inner js-file-line">          <span class="pl-c">// We found a visited node via not visited edges paths - not a tree.</span></td>
      </tr>
      <tr>
        <td id="L338" class="blob-num js-line-number" data-line-number="338"></td>
        <td id="LC338" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">return</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L339" class="blob-num js-line-number" data-line-number="339"></td>
        <td id="LC339" class="blob-code blob-code-inner js-file-line">        }</td>
      </tr>
      <tr>
        <td id="L340" class="blob-num js-line-number" data-line-number="340"></td>
        <td id="LC340" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L341" class="blob-num js-line-number" data-line-number="341"></td>
        <td id="LC341" class="blob-code blob-code-inner js-file-line">        visitedNodes <span class="pl-k">++</span><span class="pl-k">=</span> nodesToVisit</td>
      </tr>
      <tr>
        <td id="L342" class="blob-num js-line-number" data-line-number="342"></td>
        <td id="LC342" class="blob-code blob-code-inner js-file-line">        scheduled <span class="pl-k">++</span><span class="pl-k">=</span> nodesToVisit</td>
      </tr>
      <tr>
        <td id="L343" class="blob-num js-line-number" data-line-number="343"></td>
        <td id="LC343" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L344" class="blob-num js-line-number" data-line-number="344"></td>
        <td id="LC344" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L345" class="blob-num js-line-number" data-line-number="345"></td>
        <td id="LC345" class="blob-code blob-code-inner js-file-line">      graph.nodes.values.toSet <span class="pl-k">==</span> visitedNodes</td>
      </tr>
      <tr>
        <td id="L346" class="blob-num js-line-number" data-line-number="346"></td>
        <td id="LC346" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L347" class="blob-num js-line-number" data-line-number="347"></td>
        <td id="LC347" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L348" class="blob-num js-line-number" data-line-number="348"></td>
        <td id="LC348" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">permutateEdges</span>(<span class="pl-v">lst</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>]] <span class="pl-k">=</span> lst <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L349" class="blob-num js-line-number" data-line-number="349"></td>
        <td id="LC349" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(<span class="pl-c1">Nil</span>)</td>
      </tr>
      <tr>
        <td id="L350" class="blob-num js-line-number" data-line-number="350"></td>
        <td id="LC350" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> head <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> permutateEdges(tail) <span class="pl-k">:::</span> (permutateEdges(tail) map { head <span class="pl-k">::</span> _ })</td>
      </tr>
      <tr>
        <td id="L351" class="blob-num js-line-number" data-line-number="351"></td>
        <td id="LC351" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L352" class="blob-num js-line-number" data-line-number="352"></td>
        <td id="LC352" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L353" class="blob-num js-line-number" data-line-number="353"></td>
        <td id="LC353" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">for</span> (<span class="pl-v">edgeMap</span> : <span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>] <span class="pl-k">&lt;</span><span class="pl-k">-</span> permutateEdges(graph.edges);</td>
      </tr>
      <tr>
        <td id="L354" class="blob-num js-line-number" data-line-number="354"></td>
        <td id="LC354" class="blob-code blob-code-inner js-file-line">         newGraph <span class="pl-k">=</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>](graph.nodes.keys.toList, edgeMap map {<span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(graph.<span class="pl-en">Node</span>(n1), graph.<span class="pl-en">Node</span>(n2), value) <span class="pl-k">=&gt;</span> (n1, n2, value)})</td>
      </tr>
      <tr>
        <td id="L355" class="blob-num js-line-number" data-line-number="355"></td>
        <td id="LC355" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">if</span> isGraphConnected(newGraph)) <span class="pl-k">yield</span> newGraph</td>
      </tr>
      <tr>
        <td id="L356" class="blob-num js-line-number" data-line-number="356"></td>
        <td id="LC356" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L357" class="blob-num js-line-number" data-line-number="357"></td>
        <td id="LC357" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L358" class="blob-num js-line-number" data-line-number="358"></td>
        <td id="LC358" class="blob-code blob-code-inner js-file-line">  out(p83(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, a-c]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c, a-b]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-c, a-b]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-c, b-c]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L359" class="blob-num js-line-number" data-line-number="359"></td>
        <td id="LC359" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L360" class="blob-num js-line-number" data-line-number="360"></td>
        <td id="LC360" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p83_2</span>(<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L361" class="blob-num js-line-number" data-line-number="361"></td>
        <td id="LC361" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">listEdgeEquals</span>(<span class="pl-v">l</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>], <span class="pl-v">s</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L362" class="blob-num js-line-number" data-line-number="362"></td>
        <td id="LC362" class="blob-code blob-code-inner js-file-line">      l.size <span class="pl-k">==</span> s.size <span class="pl-k">&amp;&amp;</span> l.forall(l_edge <span class="pl-k">=&gt;</span> s.exists(s_edge <span class="pl-k">=&gt;</span> (l_edge.n1 <span class="pl-k">==</span> s_edge.n1 <span class="pl-k">&amp;&amp;</span> l_edge.n2 <span class="pl-k">==</span> s_edge.n2) <span class="pl-k">||</span> (l_edge.n2 <span class="pl-k">==</span> s_edge.n1 <span class="pl-k">&amp;&amp;</span> l_edge.n1 <span class="pl-k">==</span> s_edge.n2)))</td>
      </tr>
      <tr>
        <td id="L363" class="blob-num js-line-number" data-line-number="363"></td>
        <td id="LC363" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L364" class="blob-num js-line-number" data-line-number="364"></td>
        <td id="LC364" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">@</span>tailrec</td>
      </tr>
      <tr>
        <td id="L365" class="blob-num js-line-number" data-line-number="365"></td>
        <td id="LC365" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">removeDuplicates</span>(<span class="pl-v">l</span>: <span class="pl-en">List</span>[<span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>]], <span class="pl-v">filteredObjects</span>: <span class="pl-en">Set</span>[<span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>]])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>]] <span class="pl-k">=</span> l <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L366" class="blob-num js-line-number" data-line-number="366"></td>
        <td id="LC366" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> filteredObjects.toList.map(_.toList)</td>
      </tr>
      <tr>
        <td id="L367" class="blob-num js-line-number" data-line-number="367"></td>
        <td id="LC367" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> head <span class="pl-k">::</span> tail <span class="pl-k">if</span> filteredObjects.exists(listEdgeEquals(head, _)) <span class="pl-k">=&gt;</span> removeDuplicates(tail, filteredObjects)</td>
      </tr>
      <tr>
        <td id="L368" class="blob-num js-line-number" data-line-number="368"></td>
        <td id="LC368" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> head <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> removeDuplicates(tail, filteredObjects <span class="pl-k">+</span> head.toSet)</td>
      </tr>
      <tr>
        <td id="L369" class="blob-num js-line-number" data-line-number="369"></td>
        <td id="LC369" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L370" class="blob-num js-line-number" data-line-number="370"></td>
        <td id="LC370" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L371" class="blob-num js-line-number" data-line-number="371"></td>
        <td id="LC371" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">collectSpanTrees</span>(<span class="pl-v">fringe</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Node</span>], <span class="pl-v">visitedNodes</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Node</span>], <span class="pl-v">visitedEdges</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>]] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L372" class="blob-num js-line-number" data-line-number="372"></td>
        <td id="LC372" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (visitedNodes.size <span class="pl-k">==</span> graph.nodes.size) {</td>
      </tr>
      <tr>
        <td id="L373" class="blob-num js-line-number" data-line-number="373"></td>
        <td id="LC373" class="blob-code blob-code-inner js-file-line">        <span class="pl-en">List</span>(visitedEdges.toList)</td>
      </tr>
      <tr>
        <td id="L374" class="blob-num js-line-number" data-line-number="374"></td>
        <td id="LC374" class="blob-code blob-code-inner js-file-line">      } <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L375" class="blob-num js-line-number" data-line-number="375"></td>
        <td id="LC375" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">proposedData</span> <span class="pl-k">=</span> graph.edges filter {<span class="pl-k">!</span>visitedEdges.contains(_)} collect {</td>
      </tr>
      <tr>
        <td id="L376" class="blob-num js-line-number" data-line-number="376"></td>
        <td id="LC376" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(<span class="pl-v">n1</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">n2</span>: graph.<span class="pl-en">Node</span>, _) <span class="pl-k">if</span> fringe.contains(n1) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>visitedNodes.contains(n2) <span class="pl-k">=&gt;</span> (e, n2, n1)</td>
      </tr>
      <tr>
        <td id="L377" class="blob-num js-line-number" data-line-number="377"></td>
        <td id="LC377" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(<span class="pl-v">n1</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">n2</span>: graph.<span class="pl-en">Node</span>, _) <span class="pl-k">if</span> fringe.contains(n2) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>visitedNodes.contains(n1) <span class="pl-k">=&gt;</span> (e, n1, n2)</td>
      </tr>
      <tr>
        <td id="L378" class="blob-num js-line-number" data-line-number="378"></td>
        <td id="LC378" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L379" class="blob-num js-line-number" data-line-number="379"></td>
        <td id="LC379" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L380" class="blob-num js-line-number" data-line-number="380"></td>
        <td id="LC380" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">for</span> ((newEdge, newNode, oldNode) <span class="pl-k">&lt;</span><span class="pl-k">-</span> proposedData;</td>
      </tr>
      <tr>
        <td id="L381" class="blob-num js-line-number" data-line-number="381"></td>
        <td id="LC381" class="blob-code blob-code-inner js-file-line">           newGraph <span class="pl-k">&lt;</span><span class="pl-k">-</span> collectSpanTrees(fringe <span class="pl-k">+</span> newNode, visitedNodes <span class="pl-k">+</span> newNode, visitedEdges <span class="pl-k">+</span> newEdge))</td>
      </tr>
      <tr>
        <td id="L382" class="blob-num js-line-number" data-line-number="382"></td>
        <td id="LC382" class="blob-code blob-code-inner js-file-line">         <span class="pl-k">yield</span> newGraph</td>
      </tr>
      <tr>
        <td id="L383" class="blob-num js-line-number" data-line-number="383"></td>
        <td id="LC383" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L384" class="blob-num js-line-number" data-line-number="384"></td>
        <td id="LC384" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L385" class="blob-num js-line-number" data-line-number="385"></td>
        <td id="LC385" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">startNode</span> <span class="pl-k">=</span> graph.nodes.values.head</td>
      </tr>
      <tr>
        <td id="L386" class="blob-num js-line-number" data-line-number="386"></td>
        <td id="LC386" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">toList</span> <span class="pl-k">=</span> removeDuplicates(collectSpanTrees(<span class="pl-en">Set</span>(startNode), <span class="pl-en">Set</span>(startNode), <span class="pl-en">Set</span>.empty), <span class="pl-en">Set</span>.empty)</td>
      </tr>
      <tr>
        <td id="L387" class="blob-num js-line-number" data-line-number="387"></td>
        <td id="LC387" class="blob-code blob-code-inner js-file-line">    toList map {</td>
      </tr>
      <tr>
        <td id="L388" class="blob-num js-line-number" data-line-number="388"></td>
        <td id="LC388" class="blob-code blob-code-inner js-file-line">      edgeList <span class="pl-k">=&gt;</span> <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>](graph.nodes.keys.toList, edgeList map {<span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(graph.<span class="pl-en">Node</span>(n1), graph.<span class="pl-en">Node</span>(n2), v) <span class="pl-k">=&gt;</span> (n1, n2, v)})</td>
      </tr>
      <tr>
        <td id="L389" class="blob-num js-line-number" data-line-number="389"></td>
        <td id="LC389" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L390" class="blob-num js-line-number" data-line-number="390"></td>
        <td id="LC390" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L391" class="blob-num js-line-number" data-line-number="391"></td>
        <td id="LC391" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L392" class="blob-num js-line-number" data-line-number="392"></td>
        <td id="LC392" class="blob-code blob-code-inner js-file-line">  out(p83_2(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, a-c]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c, a-c]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, a-c]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L393" class="blob-num js-line-number" data-line-number="393"></td>
        <td id="LC393" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L394" class="blob-num js-line-number" data-line-number="394"></td>
        <td id="LC394" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p83_3</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L395" class="blob-num js-line-number" data-line-number="395"></td>
        <td id="LC395" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">edgeConnectsToGraph</span>[<span class="pl-en">T</span>,<span class="pl-en">U</span>](<span class="pl-v">e</span>: graph.<span class="pl-en">Edge</span>, <span class="pl-v">nodes</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L396" class="blob-num js-line-number" data-line-number="396"></td>
        <td id="LC396" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">!</span>(nodes.contains(e.n1) <span class="pl-k">==</span> nodes.contains(e.n2))</td>
      </tr>
      <tr>
        <td id="L397" class="blob-num js-line-number" data-line-number="397"></td>
        <td id="LC397" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L398" class="blob-num js-line-number" data-line-number="398"></td>
        <td id="LC398" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">spanningTreesR</span>(<span class="pl-v">graphEdges</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>], <span class="pl-v">graphNodes</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Node</span>], <span class="pl-v">treeEdges</span>: <span class="pl-en">List</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Graph</span>[<span class="pl-en">T</span>,<span class="pl-en">U</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L399" class="blob-num js-line-number" data-line-number="399"></td>
        <td id="LC399" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (graphNodes <span class="pl-k">==</span> <span class="pl-c1">Nil</span>) <span class="pl-en">List</span>(<span class="pl-en">Graph</span>(graph.nodes.keys.toList, treeEdges.map(_.toTuple)))</td>
      </tr>
      <tr>
        <td id="L400" class="blob-num js-line-number" data-line-number="400"></td>
        <td id="LC400" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> <span class="pl-k">if</span> (graphEdges <span class="pl-k">==</span> <span class="pl-c1">Nil</span>) <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L401" class="blob-num js-line-number" data-line-number="401"></td>
        <td id="LC401" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> graphEdges.filter(edgeConnectsToGraph(_, graphNodes)) flatMap { ge <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L402" class="blob-num js-line-number" data-line-number="402"></td>
        <td id="LC402" class="blob-code blob-code-inner js-file-line">        spanningTreesR(graphEdges.filterNot(_ <span class="pl-k">==</span> ge),</td>
      </tr>
      <tr>
        <td id="L403" class="blob-num js-line-number" data-line-number="403"></td>
        <td id="LC403" class="blob-code blob-code-inner js-file-line">          graphNodes.filter(graph.edgeTarget(ge, _) <span class="pl-k">==</span> <span class="pl-c1">None</span>),</td>
      </tr>
      <tr>
        <td id="L404" class="blob-num js-line-number" data-line-number="404"></td>
        <td id="LC404" class="blob-code blob-code-inner js-file-line">          ge <span class="pl-k">::</span> treeEdges)</td>
      </tr>
      <tr>
        <td id="L405" class="blob-num js-line-number" data-line-number="405"></td>
        <td id="LC405" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L406" class="blob-num js-line-number" data-line-number="406"></td>
        <td id="LC406" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L407" class="blob-num js-line-number" data-line-number="407"></td>
        <td id="LC407" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L408" class="blob-num js-line-number" data-line-number="408"></td>
        <td id="LC408" class="blob-code blob-code-inner js-file-line">    spanningTreesR(graph.edges, graph.nodes.values.toList.tail, <span class="pl-c1">Nil</span>).distinct</td>
      </tr>
      <tr>
        <td id="L409" class="blob-num js-line-number" data-line-number="409"></td>
        <td id="LC409" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L410" class="blob-num js-line-number" data-line-number="410"></td>
        <td id="LC410" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L411" class="blob-num js-line-number" data-line-number="411"></td>
        <td id="LC411" class="blob-code blob-code-inner js-file-line">  out(p83_3(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, a-c]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-c, b-c]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-c, a-b]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[b-c, a-b]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L412" class="blob-num js-line-number" data-line-number="412"></td>
        <td id="LC412" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L413" class="blob-num js-line-number" data-line-number="413"></td>
        <td id="LC413" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P84. Construct the minimal spanning tree (with Prim&#39;s Algorithm)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L414" class="blob-num js-line-number" data-line-number="414"></td>
        <td id="LC414" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L415" class="blob-num js-line-number" data-line-number="415"></td>
        <td id="LC415" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p84</span>(<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Int</span>]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L416" class="blob-num js-line-number" data-line-number="416"></td>
        <td id="LC416" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">@</span>tailrec</td>
      </tr>
      <tr>
        <td id="L417" class="blob-num js-line-number" data-line-number="417"></td>
        <td id="LC417" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">nodes</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Node</span>], <span class="pl-v">edges</span>: <span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>])<span class="pl-k">:</span> <span class="pl-en">Set</span>[graph.<span class="pl-en">Edge</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L418" class="blob-num js-line-number" data-line-number="418"></td>
        <td id="LC418" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (nodes.size <span class="pl-k">==</span> graph.nodes.size) {</td>
      </tr>
      <tr>
        <td id="L419" class="blob-num js-line-number" data-line-number="419"></td>
        <td id="LC419" class="blob-code blob-code-inner js-file-line">        edges</td>
      </tr>
      <tr>
        <td id="L420" class="blob-num js-line-number" data-line-number="420"></td>
        <td id="LC420" class="blob-code blob-code-inner js-file-line">      } <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L421" class="blob-num js-line-number" data-line-number="421"></td>
        <td id="LC421" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> (selectedNode, selectedEdge) <span class="pl-k">=</span> graph.edges.toSet diff edges collect {</td>
      </tr>
      <tr>
        <td id="L422" class="blob-num js-line-number" data-line-number="422"></td>
        <td id="LC422" class="blob-code blob-code-inner js-file-line">            <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(<span class="pl-v">n1</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">n2</span>: graph.<span class="pl-en">Node</span>, _) <span class="pl-k">if</span> nodes.contains(n1) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>nodes.contains(n2) <span class="pl-k">=&gt;</span> (n2, e)</td>
      </tr>
      <tr>
        <td id="L423" class="blob-num js-line-number" data-line-number="423"></td>
        <td id="LC423" class="blob-code blob-code-inner js-file-line">            <span class="pl-k">case</span> e<span class="pl-k">@</span>graph.<span class="pl-en">Edge</span>(<span class="pl-v">n1</span>: graph.<span class="pl-en">Node</span>, <span class="pl-v">n2</span>: graph.<span class="pl-en">Node</span>, _) <span class="pl-k">if</span> nodes.contains(n2) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>nodes.contains(n1) <span class="pl-k">=&gt;</span> (n1, e)</td>
      </tr>
      <tr>
        <td id="L424" class="blob-num js-line-number" data-line-number="424"></td>
        <td id="LC424" class="blob-code blob-code-inner js-file-line">          } minBy {</td>
      </tr>
      <tr>
        <td id="L425" class="blob-num js-line-number" data-line-number="425"></td>
        <td id="LC425" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> (_, graph.<span class="pl-en">Edge</span>(_, _, <span class="pl-en">Some</span>(v))) <span class="pl-k">=&gt;</span> v</td>
      </tr>
      <tr>
        <td id="L426" class="blob-num js-line-number" data-line-number="426"></td>
        <td id="LC426" class="blob-code blob-code-inner js-file-line">          }</td>
      </tr>
      <tr>
        <td id="L427" class="blob-num js-line-number" data-line-number="427"></td>
        <td id="LC427" class="blob-code blob-code-inner js-file-line">        inner(nodes <span class="pl-k">+</span> selectedNode, edges <span class="pl-k">+</span> selectedEdge)</td>
      </tr>
      <tr>
        <td id="L428" class="blob-num js-line-number" data-line-number="428"></td>
        <td id="LC428" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L429" class="blob-num js-line-number" data-line-number="429"></td>
        <td id="LC429" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L430" class="blob-num js-line-number" data-line-number="430"></td>
        <td id="LC430" class="blob-code blob-code-inner js-file-line">    <span class="pl-en">Graph</span>(graph.nodes.keys.toList, inner(<span class="pl-en">Set</span>(graph.nodes.head._2), <span class="pl-en">Set</span>.empty).toList map {<span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(graph.<span class="pl-en">Node</span>(n1), graph.<span class="pl-en">Node</span>(n2), <span class="pl-en">Some</span>(v)) <span class="pl-k">=&gt;</span> (n1, n2, <span class="pl-en">Some</span>(v))})</td>
      </tr>
      <tr>
        <td id="L431" class="blob-num js-line-number" data-line-number="431"></td>
        <td id="LC431" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L432" class="blob-num js-line-number" data-line-number="432"></td>
        <td id="LC432" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L433" class="blob-num js-line-number" data-line-number="433"></td>
        <td id="LC433" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">val</span> <span class="pl-en">t_84</span> <span class="pl-k">=</span> <span class="pl-en">Graph</span>.termLabel(</td>
      </tr>
      <tr>
        <td id="L434" class="blob-num js-line-number" data-line-number="434"></td>
        <td id="LC434" class="blob-code blob-code-inner js-file-line">    <span class="pl-en">List</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>),</td>
      </tr>
      <tr>
        <td id="L435" class="blob-num js-line-number" data-line-number="435"></td>
        <td id="LC435" class="blob-code blob-code-inner js-file-line">    <span class="pl-en">List</span>((<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">5</span>), (<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">3</span>), (<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">2</span>), (<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">4</span>),</td>
      </tr>
      <tr>
        <td id="L436" class="blob-num js-line-number" data-line-number="436"></td>
        <td id="LC436" class="blob-code blob-code-inner js-file-line">      (<span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">6</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">7</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">4</span>), (<span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">3</span>),</td>
      </tr>
      <tr>
        <td id="L437" class="blob-num js-line-number" data-line-number="437"></td>
        <td id="LC437" class="blob-code blob-code-inner js-file-line">      (<span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>, <span class="pl-c1">5</span>), (<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">4</span>), (<span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;h&#39;</span>, <span class="pl-c1">1</span>)))</td>
      </tr>
      <tr>
        <td id="L438" class="blob-num js-line-number" data-line-number="438"></td>
        <td id="LC438" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L439" class="blob-num js-line-number" data-line-number="439"></td>
        <td id="LC439" class="blob-code blob-code-inner js-file-line">  out(p84(t_84)) <span class="pl-k">===</span> <span class="pl-en">Graph</span>.fromStringNum(<span class="pl-s"><span class="pl-pds">&quot;</span>[g-h/1, b-e/4, f-g/4, e-h/5, d-g/3, a-d/3, b-c/2]<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L440" class="blob-num js-line-number" data-line-number="440"></td>
        <td id="LC440" class="blob-code blob-code-inner js-file-line">  out(p84(<span class="pl-en">Graph</span>.fromStringNum(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b/1, b-c/2, a-c/3]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-en">Graph</span>.fromStringNum(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b/1, b-c/2]<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L441" class="blob-num js-line-number" data-line-number="441"></td>
        <td id="LC441" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L442" class="blob-num js-line-number" data-line-number="442"></td>
        <td id="LC442" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L443" class="blob-num js-line-number" data-line-number="443"></td>
        <td id="LC443" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P85. Graph isomorphism.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L444" class="blob-num js-line-number" data-line-number="444"></td>
        <td id="LC444" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L445" class="blob-num js-line-number" data-line-number="445"></td>
        <td id="LC445" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p85</span>(<span class="pl-v">a</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>], <span class="pl-v">b</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L446" class="blob-num js-line-number" data-line-number="446"></td>
        <td id="LC446" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">getConnectedNodes</span>(<span class="pl-v">graph</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>])(<span class="pl-v">node</span>: graph.<span class="pl-en">Node</span>) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L447" class="blob-num js-line-number" data-line-number="447"></td>
        <td id="LC447" class="blob-code blob-code-inner js-file-line">      graph.edges collect {</td>
      </tr>
      <tr>
        <td id="L448" class="blob-num js-line-number" data-line-number="448"></td>
        <td id="LC448" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(n1, n2, _) <span class="pl-k">if</span> n1 <span class="pl-k">==</span> node <span class="pl-k">=&gt;</span> n2</td>
      </tr>
      <tr>
        <td id="L449" class="blob-num js-line-number" data-line-number="449"></td>
        <td id="LC449" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> graph.<span class="pl-en">Edge</span>(n1, n2, _) <span class="pl-k">if</span> n2 <span class="pl-k">==</span> node <span class="pl-k">=&gt;</span> n1</td>
      </tr>
      <tr>
        <td id="L450" class="blob-num js-line-number" data-line-number="450"></td>
        <td id="LC450" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L451" class="blob-num js-line-number" data-line-number="451"></td>
        <td id="LC451" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L452" class="blob-num js-line-number" data-line-number="452"></td>
        <td id="LC452" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">areNodesUniquilyConnected</span>[<span class="pl-en">T</span>](<span class="pl-v">l</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>], <span class="pl-v">connectedTo</span>: <span class="pl-en">List</span>[<span class="pl-en">T</span>]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L453" class="blob-num js-line-number" data-line-number="453"></td>
        <td id="LC453" class="blob-code blob-code-inner js-file-line">      l <span class="pl-k">==</span> <span class="pl-c1">Nil</span> <span class="pl-k">||</span> (l.distinct.size <span class="pl-k">==</span> l.size <span class="pl-k">&amp;&amp;</span> l.forall(connectedTo.contains(_)))</td>
      </tr>
      <tr>
        <td id="L454" class="blob-num js-line-number" data-line-number="454"></td>
        <td id="LC454" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L455" class="blob-num js-line-number" data-line-number="455"></td>
        <td id="LC455" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L456" class="blob-num js-line-number" data-line-number="456"></td>
        <td id="LC456" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isValidArity</span>(<span class="pl-v">nodeA</span>: a.<span class="pl-en">Node</span>, <span class="pl-v">nodeB</span>: b.<span class="pl-en">Node</span>) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L457" class="blob-num js-line-number" data-line-number="457"></td>
        <td id="LC457" class="blob-code blob-code-inner js-file-line">      getConnectedNodes(a)(nodeA).size <span class="pl-k">==</span> getConnectedNodes(b)(nodeB).size</td>
      </tr>
      <tr>
        <td id="L458" class="blob-num js-line-number" data-line-number="458"></td>
        <td id="LC458" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L459" class="blob-num js-line-number" data-line-number="459"></td>
        <td id="LC459" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">mapped</span>: <span class="pl-en">List</span>[(a.<span class="pl-en">Node</span>, b.<span class="pl-en">Node</span>)], <span class="pl-v">aLeft</span>: <span class="pl-en">List</span>[a.<span class="pl-en">Node</span>], <span class="pl-v">bLeft</span>: <span class="pl-en">List</span>[b.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L460" class="blob-num js-line-number" data-line-number="460"></td>
        <td id="LC460" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (aLeft <span class="pl-k">==</span> <span class="pl-c1">Nil</span> <span class="pl-k">&amp;&amp;</span> bLeft <span class="pl-k">==</span> <span class="pl-c1">Nil</span>) <span class="pl-c1">true</span> <span class="pl-k">else</span></td>
      </tr>
      <tr>
        <td id="L461" class="blob-num js-line-number" data-line-number="461"></td>
        <td id="LC461" class="blob-code blob-code-inner js-file-line">      (<span class="pl-k">for</span> (bNode <span class="pl-k">&lt;</span><span class="pl-k">-</span> bLeft;</td>
      </tr>
      <tr>
        <td id="L462" class="blob-num js-line-number" data-line-number="462"></td>
        <td id="LC462" class="blob-code blob-code-inner js-file-line">            bConnectedNodes <span class="pl-k">=</span> getConnectedNodes(b)(bNode);</td>
      </tr>
      <tr>
        <td id="L463" class="blob-num js-line-number" data-line-number="463"></td>
        <td id="LC463" class="blob-code blob-code-inner js-file-line">            aNode <span class="pl-k">&lt;</span><span class="pl-k">-</span> aLeft;</td>
      </tr>
      <tr>
        <td id="L464" class="blob-num js-line-number" data-line-number="464"></td>
        <td id="LC464" class="blob-code blob-code-inner js-file-line">            bSupposedlyConnectedNodes <span class="pl-k">=</span> getConnectedNodes(a)(aNode) map {node <span class="pl-k">=&gt;</span> mapped collectFirst { <span class="pl-k">case</span> (`node`, v) <span class="pl-k">=&gt;</span> v }} collect { <span class="pl-k">case</span> <span class="pl-en">Some</span>(v) <span class="pl-k">=&gt;</span> v}</td>
      </tr>
      <tr>
        <td id="L465" class="blob-num js-line-number" data-line-number="465"></td>
        <td id="LC465" class="blob-code blob-code-inner js-file-line">            <span class="pl-k">if</span> isValidArity(aNode, bNode) <span class="pl-k">&amp;&amp;</span> areNodesUniquilyConnected(bSupposedlyConnectedNodes, bConnectedNodes))</td>
      </tr>
      <tr>
        <td id="L466" class="blob-num js-line-number" data-line-number="466"></td>
        <td id="LC466" class="blob-code blob-code-inner js-file-line">                <span class="pl-k">yield</span> inner((aNode, bNode) <span class="pl-k">::</span> mapped, aLeft diff <span class="pl-en">List</span>(aNode), bLeft diff <span class="pl-en">List</span>(bNode))</td>
      </tr>
      <tr>
        <td id="L467" class="blob-num js-line-number" data-line-number="467"></td>
        <td id="LC467" class="blob-code blob-code-inner js-file-line">        ).exists(identity)</td>
      </tr>
      <tr>
        <td id="L468" class="blob-num js-line-number" data-line-number="468"></td>
        <td id="LC468" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L469" class="blob-num js-line-number" data-line-number="469"></td>
        <td id="LC469" class="blob-code blob-code-inner js-file-line">    inner(<span class="pl-c1">Nil</span>, a.nodes.values.toList, b.nodes.values.toList)</td>
      </tr>
      <tr>
        <td id="L470" class="blob-num js-line-number" data-line-number="470"></td>
        <td id="LC470" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L471" class="blob-num js-line-number" data-line-number="471"></td>
        <td id="LC471" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L472" class="blob-num js-line-number" data-line-number="472"></td>
        <td id="LC472" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p85_c</span>(<span class="pl-v">a</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>], <span class="pl-v">b</span>: <span class="pl-en">Graph</span>[<span class="pl-k">Char</span>, <span class="pl-k">Char</span>]) <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L473" class="blob-num js-line-number" data-line-number="473"></td>
        <td id="LC473" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">ra</span> <span class="pl-k">=</span> p85(a, b)</td>
      </tr>
      <tr>
        <td id="L474" class="blob-num js-line-number" data-line-number="474"></td>
        <td id="LC474" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">rb</span> <span class="pl-k">=</span> p85(a, b)</td>
      </tr>
      <tr>
        <td id="L475" class="blob-num js-line-number" data-line-number="475"></td>
        <td id="LC475" class="blob-code blob-code-inner js-file-line">    assert(ra <span class="pl-k">==</span> rb)</td>
      </tr>
      <tr>
        <td id="L476" class="blob-num js-line-number" data-line-number="476"></td>
        <td id="LC476" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L477" class="blob-num js-line-number" data-line-number="477"></td>
        <td id="LC477" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L478" class="blob-num js-line-number" data-line-number="478"></td>
        <td id="LC478" class="blob-code blob-code-inner js-file-line">  p85_c(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[d-e]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L479" class="blob-num js-line-number" data-line-number="479"></td>
        <td id="LC479" class="blob-code blob-code-inner js-file-line">  p85_c(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[d-e, e-g]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L480" class="blob-num js-line-number" data-line-number="480"></td>
        <td id="LC480" class="blob-code blob-code-inner js-file-line">  p85_c(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[d-e, e-d]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L481" class="blob-num js-line-number" data-line-number="481"></td>
        <td id="LC481" class="blob-code blob-code-inner js-file-line">  p85_c(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, c-a]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[d-e, e-g, g-d]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L482" class="blob-num js-line-number" data-line-number="482"></td>
        <td id="LC482" class="blob-code blob-code-inner js-file-line">  p85_c(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, c-a]<span class="pl-pds">&quot;</span></span>), <span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[d-e, e-g, g-e]<span class="pl-pds">&quot;</span></span>))</td>
      </tr>
      <tr>
        <td id="L483" class="blob-num js-line-number" data-line-number="483"></td>
        <td id="LC483" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L484" class="blob-num js-line-number" data-line-number="484"></td>
        <td id="LC484" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p85_2</span>[<span class="pl-en">R</span>,<span class="pl-en">S</span>](<span class="pl-v">g</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">R</span>, <span class="pl-en">S</span>], <span class="pl-v">o</span>: <span class="pl-en">GraphBase</span>[<span class="pl-en">R</span>, <span class="pl-en">S</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L485" class="blob-num js-line-number" data-line-number="485"></td>
        <td id="LC485" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">// Build a lazy list so we only have to evaluate as much as necessary.</span></td>
      </tr>
      <tr>
        <td id="L486" class="blob-num js-line-number" data-line-number="486"></td>
        <td id="LC486" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">listMappings</span>(<span class="pl-v">tNodes</span>: <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>], <span class="pl-v">oNodes</span>: <span class="pl-en">List</span>[o.<span class="pl-en">Node</span>]) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L487" class="blob-num js-line-number" data-line-number="487"></td>
        <td id="LC487" class="blob-code blob-code-inner js-file-line">      tNodes.view.flatMap(tn <span class="pl-k">=&gt;</span> oNodes.view.map((tn, _)))</td>
      </tr>
      <tr>
        <td id="L488" class="blob-num js-line-number" data-line-number="488"></td>
        <td id="LC488" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">// Used on partially-filled isomorphisms to weed out some early.</span></td>
      </tr>
      <tr>
        <td id="L489" class="blob-num js-line-number" data-line-number="489"></td>
        <td id="LC489" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isValidMapping</span>(<span class="pl-v">iso</span>: <span class="pl-en">Map</span>[g.<span class="pl-en">Node</span>,o.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L490" class="blob-num js-line-number" data-line-number="490"></td>
        <td id="LC490" class="blob-code blob-code-inner js-file-line">      g.nodes.values forall {tn <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L491" class="blob-num js-line-number" data-line-number="491"></td>
        <td id="LC491" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">!</span>iso.contains(tn) <span class="pl-k">||</span></td>
      </tr>
      <tr>
        <td id="L492" class="blob-num js-line-number" data-line-number="492"></td>
        <td id="LC492" class="blob-code blob-code-inner js-file-line">          tn.neighbors.filter(iso.contains).forall(tnn <span class="pl-k">=&gt;</span> iso(tn).neighbors.contains(iso(tnn)))</td>
      </tr>
      <tr>
        <td id="L493" class="blob-num js-line-number" data-line-number="493"></td>
        <td id="LC493" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L494" class="blob-num js-line-number" data-line-number="494"></td>
        <td id="LC494" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isValidCompleteMapping</span>(<span class="pl-v">iso</span>: <span class="pl-en">Map</span>[g.<span class="pl-en">Node</span>,o.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L495" class="blob-num js-line-number" data-line-number="495"></td>
        <td id="LC495" class="blob-code blob-code-inner js-file-line">      g.nodes.values forall {tn <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L496" class="blob-num js-line-number" data-line-number="496"></td>
        <td id="LC496" class="blob-code blob-code-inner js-file-line">        <span class="pl-en">Set</span>(tn.neighbors.map(x <span class="pl-k">=&gt;</span> iso.apply(x))<span class="pl-k">:</span> _<span class="pl-k">*</span>) <span class="pl-k">==</span> <span class="pl-en">Set</span>(iso(tn).neighbors<span class="pl-k">:</span> _<span class="pl-k">*</span>)</td>
      </tr>
      <tr>
        <td id="L497" class="blob-num js-line-number" data-line-number="497"></td>
        <td id="LC497" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L498" class="blob-num js-line-number" data-line-number="498"></td>
        <td id="LC498" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">isIsomorphicToR</span>(<span class="pl-v">tNodes</span>: <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>], <span class="pl-v">oNodes</span>: <span class="pl-en">List</span>[o.<span class="pl-en">Node</span>], <span class="pl-v">iso</span>: <span class="pl-en">Map</span>[g.<span class="pl-en">Node</span>,o.<span class="pl-en">Node</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L499" class="blob-num js-line-number" data-line-number="499"></td>
        <td id="LC499" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (tNodes <span class="pl-k">==</span> <span class="pl-c1">Nil</span>) isValidCompleteMapping(iso)</td>
      </tr>
      <tr>
        <td id="L500" class="blob-num js-line-number" data-line-number="500"></td>
        <td id="LC500" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> listMappings(tNodes, oNodes).filter(p <span class="pl-k">=&gt;</span> isValidMapping(iso <span class="pl-k">+</span> p)) exists {p <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L501" class="blob-num js-line-number" data-line-number="501"></td>
        <td id="LC501" class="blob-code blob-code-inner js-file-line">        isIsomorphicToR(tNodes diff <span class="pl-en">List</span>(p._1), oNodes diff <span class="pl-en">List</span>(p._2), iso <span class="pl-k">+</span> p)</td>
      </tr>
      <tr>
        <td id="L502" class="blob-num js-line-number" data-line-number="502"></td>
        <td id="LC502" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L503" class="blob-num js-line-number" data-line-number="503"></td>
        <td id="LC503" class="blob-code blob-code-inner js-file-line">    isIsomorphicToR(g.nodes.values.toList, o.nodes.values.toList, <span class="pl-en">Map</span>())</td>
      </tr>
      <tr>
        <td id="L504" class="blob-num js-line-number" data-line-number="504"></td>
        <td id="LC504" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L505" class="blob-num js-line-number" data-line-number="505"></td>
        <td id="LC505" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L506" class="blob-num js-line-number" data-line-number="506"></td>
        <td id="LC506" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P86. Node degree and graph coloration.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L507" class="blob-num js-line-number" data-line-number="507"></td>
        <td id="LC507" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L508" class="blob-num js-line-number" data-line-number="508"></td>
        <td id="LC508" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p86</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])(<span class="pl-v">node</span>: g.<span class="pl-en">Node</span>) <span class="pl-k">=</span> node.adj.size</td>
      </tr>
      <tr>
        <td id="L509" class="blob-num js-line-number" data-line-number="509"></td>
        <td id="LC509" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p86</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])(<span class="pl-v">s</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">Option</span>[<span class="pl-k">Int</span>] <span class="pl-k">=</span> g.nodes.get(s).map(_.adj.size)</td>
      </tr>
      <tr>
        <td id="L510" class="blob-num js-line-number" data-line-number="510"></td>
        <td id="LC510" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L511" class="blob-num js-line-number" data-line-number="511"></td>
        <td id="LC511" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p86_2</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>] <span class="pl-k">=</span> g.nodes.values.toList.sortBy(<span class="pl-k">-</span>_.adj.size)</td>
      </tr>
      <tr>
        <td id="L512" class="blob-num js-line-number" data-line-number="512"></td>
        <td id="LC512" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L513" class="blob-num js-line-number" data-line-number="513"></td>
        <td id="LC513" class="blob-code blob-code-inner js-file-line">  out(p86_2(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, a-c, a-d]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(Node(a), Node(c), Node(b), Node(d))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L514" class="blob-num js-line-number" data-line-number="514"></td>
        <td id="LC514" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L515" class="blob-num js-line-number" data-line-number="515"></td>
        <td id="LC515" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p86_3</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[(g.<span class="pl-en">Node</span>, <span class="pl-k">Int</span>)] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L516" class="blob-num js-line-number" data-line-number="516"></td>
        <td id="LC516" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">notColored</span>: <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>], <span class="pl-v">color</span>: <span class="pl-k">Int</span>) <span class="pl-k">:</span> <span class="pl-en">List</span>[(g.<span class="pl-en">Node</span>, <span class="pl-k">Int</span>)] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L517" class="blob-num js-line-number" data-line-number="517"></td>
        <td id="LC517" class="blob-code blob-code-inner js-file-line">      notColored <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L518" class="blob-num js-line-number" data-line-number="518"></td>
        <td id="LC518" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L519" class="blob-num js-line-number" data-line-number="519"></td>
        <td id="LC519" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> head <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L520" class="blob-num js-line-number" data-line-number="520"></td>
        <td id="LC520" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">val</span> (left, colored) <span class="pl-k">=</span> tail span {_.adj.exists{ <span class="pl-k">case</span> g.<span class="pl-en">Edge</span>(n1, n2, _) <span class="pl-k">=&gt;</span> n1 <span class="pl-k">==</span> head <span class="pl-k">||</span> n2 <span class="pl-k">==</span> head}}</td>
      </tr>
      <tr>
        <td id="L521" class="blob-num js-line-number" data-line-number="521"></td>
        <td id="LC521" class="blob-code blob-code-inner js-file-line">          inner(left, color <span class="pl-k">+</span> <span class="pl-c1">1</span>) <span class="pl-k">:::</span> ((head <span class="pl-k">::</span> colored) map {x <span class="pl-k">=&gt;</span> (x, color)})</td>
      </tr>
      <tr>
        <td id="L522" class="blob-num js-line-number" data-line-number="522"></td>
        <td id="LC522" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L523" class="blob-num js-line-number" data-line-number="523"></td>
        <td id="LC523" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L524" class="blob-num js-line-number" data-line-number="524"></td>
        <td id="LC524" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">p</span> <span class="pl-k">=</span> p86_2(g)</td>
      </tr>
      <tr>
        <td id="L525" class="blob-num js-line-number" data-line-number="525"></td>
        <td id="LC525" class="blob-code blob-code-inner js-file-line">    inner(p, <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L526" class="blob-num js-line-number" data-line-number="526"></td>
        <td id="LC526" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L527" class="blob-num js-line-number" data-line-number="527"></td>
        <td id="LC527" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L528" class="blob-num js-line-number" data-line-number="528"></td>
        <td id="LC528" class="blob-code blob-code-inner js-file-line">  out(p86_3(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, a-c, a-d]<span class="pl-pds">&quot;</span></span>)))</td>
      </tr>
      <tr>
        <td id="L529" class="blob-num js-line-number" data-line-number="529"></td>
        <td id="LC529" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L530" class="blob-num js-line-number" data-line-number="530"></td>
        <td id="LC530" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P87. Depth-first order graph traversal.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L531" class="blob-num js-line-number" data-line-number="531"></td>
        <td id="LC531" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L532" class="blob-num js-line-number" data-line-number="532"></td>
        <td id="LC532" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p87</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>], <span class="pl-v">from</span>: <span class="pl-en">T</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L533" class="blob-num js-line-number" data-line-number="533"></td>
        <td id="LC533" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">current</span>: g.<span class="pl-en">Node</span>, <span class="pl-v">visited</span>: <span class="pl-en">Set</span>[g.<span class="pl-en">Node</span>])<span class="pl-k">:</span> (<span class="pl-en">Set</span>[g.<span class="pl-en">Node</span>], <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>]) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L534" class="blob-num js-line-number" data-line-number="534"></td>
        <td id="LC534" class="blob-code blob-code-inner js-file-line">      current.neighbors.foldLeft((visited, <span class="pl-en">List</span>.empty[g.<span class="pl-en">Node</span>])){</td>
      </tr>
      <tr>
        <td id="L535" class="blob-num js-line-number" data-line-number="535"></td>
        <td id="LC535" class="blob-code blob-code-inner js-file-line">          <span class="pl-k">case</span> ((visitedAcc, traversalAcc), node) <span class="pl-k">=&gt;</span></td>
      </tr>
      <tr>
        <td id="L536" class="blob-num js-line-number" data-line-number="536"></td>
        <td id="LC536" class="blob-code blob-code-inner js-file-line">         <span class="pl-k">if</span> (visitedAcc.contains(node))</td>
      </tr>
      <tr>
        <td id="L537" class="blob-num js-line-number" data-line-number="537"></td>
        <td id="LC537" class="blob-code blob-code-inner js-file-line">           (visitedAcc, traversalAcc)</td>
      </tr>
      <tr>
        <td id="L538" class="blob-num js-line-number" data-line-number="538"></td>
        <td id="LC538" class="blob-code blob-code-inner js-file-line">         <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L539" class="blob-num js-line-number" data-line-number="539"></td>
        <td id="LC539" class="blob-code blob-code-inner js-file-line">           <span class="pl-k">val</span> (newVisited, newTrav) <span class="pl-k">=</span> inner(node, visitedAcc <span class="pl-k">+</span> node)</td>
      </tr>
      <tr>
        <td id="L540" class="blob-num js-line-number" data-line-number="540"></td>
        <td id="LC540" class="blob-code blob-code-inner js-file-line">           (newVisited, node <span class="pl-k">::</span> newTrav)</td>
      </tr>
      <tr>
        <td id="L541" class="blob-num js-line-number" data-line-number="541"></td>
        <td id="LC541" class="blob-code blob-code-inner js-file-line">         }</td>
      </tr>
      <tr>
        <td id="L542" class="blob-num js-line-number" data-line-number="542"></td>
        <td id="LC542" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L543" class="blob-num js-line-number" data-line-number="543"></td>
        <td id="LC543" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L544" class="blob-num js-line-number" data-line-number="544"></td>
        <td id="LC544" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">firstNode</span> <span class="pl-k">=</span> g.nodes(from)</td>
      </tr>
      <tr>
        <td id="L545" class="blob-num js-line-number" data-line-number="545"></td>
        <td id="LC545" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> (_, result) <span class="pl-k">=</span> inner(firstNode, <span class="pl-en">Set</span>(firstNode))</td>
      </tr>
      <tr>
        <td id="L546" class="blob-num js-line-number" data-line-number="546"></td>
        <td id="LC546" class="blob-code blob-code-inner js-file-line">    firstNode <span class="pl-k">::</span> result</td>
      </tr>
      <tr>
        <td id="L547" class="blob-num js-line-number" data-line-number="547"></td>
        <td id="LC547" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L548" class="blob-num js-line-number" data-line-number="548"></td>
        <td id="LC548" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L549" class="blob-num js-line-number" data-line-number="549"></td>
        <td id="LC549" class="blob-code blob-code-inner js-file-line">  out(p87(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, e, a-c, a-d]<span class="pl-pds">&quot;</span></span>), <span class="pl-c1">&#39;d&#39;</span>)) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List(Node(d), Node(a), Node(c), Node(b))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L550" class="blob-num js-line-number" data-line-number="550"></td>
        <td id="LC550" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L551" class="blob-num js-line-number" data-line-number="551"></td>
        <td id="LC551" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P88. Connected components<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L552" class="blob-num js-line-number" data-line-number="552"></td>
        <td id="LC552" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L553" class="blob-num js-line-number" data-line-number="553"></td>
        <td id="LC553" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p88</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>]] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L554" class="blob-num js-line-number" data-line-number="554"></td>
        <td id="LC554" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">createGraph</span>(<span class="pl-v">nodes</span>: <span class="pl-en">List</span>[g.<span class="pl-en">Node</span>], <span class="pl-v">edges</span>: <span class="pl-en">List</span>[g.<span class="pl-en">Edge</span>]) <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L555" class="blob-num js-line-number" data-line-number="555"></td>
        <td id="LC555" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">Graph</span>(nodes.map(_.value), g.edges.collect { <span class="pl-k">case</span> g.<span class="pl-en">Edge</span>(n1<span class="pl-k">@</span>g.<span class="pl-en">Node</span>(nv1), n2<span class="pl-k">@</span>g.<span class="pl-en">Node</span>(nv2), v) <span class="pl-k">if</span> nodes.contains(n1) <span class="pl-k">&amp;&amp;</span> nodes.contains(n2) <span class="pl-k">=&gt;</span> (nv1, nv2, v)})</td>
      </tr>
      <tr>
        <td id="L556" class="blob-num js-line-number" data-line-number="556"></td>
        <td id="LC556" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L557" class="blob-num js-line-number" data-line-number="557"></td>
        <td id="LC557" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">nodes</span> <span class="pl-k">=</span> p87(g, g.nodes.values.head.value)</td>
      </tr>
      <tr>
        <td id="L558" class="blob-num js-line-number" data-line-number="558"></td>
        <td id="LC558" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">if</span> (g.nodes.size <span class="pl-k">!=</span> nodes.size) {</td>
      </tr>
      <tr>
        <td id="L559" class="blob-num js-line-number" data-line-number="559"></td>
        <td id="LC559" class="blob-code blob-code-inner js-file-line">      createGraph(nodes, g.edges) <span class="pl-k">::</span> p88(createGraph(g.nodes.values.toList diff nodes, g.edges))</td>
      </tr>
      <tr>
        <td id="L560" class="blob-num js-line-number" data-line-number="560"></td>
        <td id="LC560" class="blob-code blob-code-inner js-file-line">    } <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L561" class="blob-num js-line-number" data-line-number="561"></td>
        <td id="LC561" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">List</span>(g)</td>
      </tr>
      <tr>
        <td id="L562" class="blob-num js-line-number" data-line-number="562"></td>
        <td id="LC562" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L563" class="blob-num js-line-number" data-line-number="563"></td>
        <td id="LC563" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L564" class="blob-num js-line-number" data-line-number="564"></td>
        <td id="LC564" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L565" class="blob-num js-line-number" data-line-number="565"></td>
        <td id="LC565" class="blob-code blob-code-inner js-file-line">  out(p88(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, c]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List([c], [a-b])<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L566" class="blob-num js-line-number" data-line-number="566"></td>
        <td id="LC566" class="blob-code blob-code-inner js-file-line">  out(p88(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, d-e]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">==</span><span class="pl-k">!</span> <span class="pl-s"><span class="pl-pds">&quot;</span>List([d-e], [a-b, b-c])<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L567" class="blob-num js-line-number" data-line-number="567"></td>
        <td id="LC567" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L568" class="blob-num js-line-number" data-line-number="568"></td>
        <td id="LC568" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P89. Bipartite graphs.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L569" class="blob-num js-line-number" data-line-number="569"></td>
        <td id="LC569" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L570" class="blob-num js-line-number" data-line-number="570"></td>
        <td id="LC570" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p89</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>](<span class="pl-v">g</span>: <span class="pl-en">Graph</span>[<span class="pl-en">T</span>, <span class="pl-en">U</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L571" class="blob-num js-line-number" data-line-number="571"></td>
        <td id="LC571" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">@</span>tailrec</td>
      </tr>
      <tr>
        <td id="L572" class="blob-num js-line-number" data-line-number="572"></td>
        <td id="LC572" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">edges</span>: <span class="pl-en">List</span>[(<span class="pl-en">T</span>, <span class="pl-en">T</span>)], <span class="pl-v">setA</span>: <span class="pl-en">Set</span>[<span class="pl-en">T</span>], <span class="pl-v">setB</span>: <span class="pl-en">Set</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Boolean</span> <span class="pl-k">=</span> edges <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L573" class="blob-num js-line-number" data-line-number="573"></td>
        <td id="LC573" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L574" class="blob-num js-line-number" data-line-number="574"></td>
        <td id="LC574" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (n1, n2) <span class="pl-k">::</span> tail <span class="pl-k">if</span> <span class="pl-k">!</span>setA.contains(n1) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>setB.contains(n2) <span class="pl-k">=&gt;</span> inner(tail, setA <span class="pl-k">+</span> n2, setB <span class="pl-k">+</span> n1)</td>
      </tr>
      <tr>
        <td id="L575" class="blob-num js-line-number" data-line-number="575"></td>
        <td id="LC575" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (n1, n2) <span class="pl-k">::</span> tail <span class="pl-k">if</span> <span class="pl-k">!</span>setA.contains(n2) <span class="pl-k">&amp;&amp;</span> <span class="pl-k">!</span>setB.contains(n1) <span class="pl-k">=&gt;</span> inner(tail, setA <span class="pl-k">+</span> n1, setB <span class="pl-k">+</span> n2)</td>
      </tr>
      <tr>
        <td id="L576" class="blob-num js-line-number" data-line-number="576"></td>
        <td id="LC576" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L577" class="blob-num js-line-number" data-line-number="577"></td>
        <td id="LC577" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L578" class="blob-num js-line-number" data-line-number="578"></td>
        <td id="LC578" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L579" class="blob-num js-line-number" data-line-number="579"></td>
        <td id="LC579" class="blob-code blob-code-inner js-file-line">    inner(p88(g).flatMap(x <span class="pl-k">=&gt;</span> x.edges.map(y <span class="pl-k">=&gt;</span> y.n1.value <span class="pl-k">-</span><span class="pl-k">&gt;</span> y.n2.value)), <span class="pl-en">Set</span>.empty, <span class="pl-en">Set</span>.empty)</td>
      </tr>
      <tr>
        <td id="L580" class="blob-num js-line-number" data-line-number="580"></td>
        <td id="LC580" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L581" class="blob-num js-line-number" data-line-number="581"></td>
        <td id="LC581" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L582" class="blob-num js-line-number" data-line-number="582"></td>
        <td id="LC582" class="blob-code blob-code-inner js-file-line">  out(p89(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, c-a]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L583" class="blob-num js-line-number" data-line-number="583"></td>
        <td id="LC583" class="blob-code blob-code-inner js-file-line">  out(p89(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, d]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L584" class="blob-num js-line-number" data-line-number="584"></td>
        <td id="LC584" class="blob-code blob-code-inner js-file-line">  out(p89(<span class="pl-en">Graph</span>.fromString(<span class="pl-s"><span class="pl-pds">&quot;</span>[a-b, b-c, d, e-f, f-g, g-e, h]<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L585" class="blob-num js-line-number" data-line-number="585"></td>
        <td id="LC585" class="blob-code blob-code-inner js-file-line">}</td>
      </tr>
</table>

  </div>

</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="" class="js-jump-to-line-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" aria-label="Jump to line" autofocus>
    <button type="submit" class="btn">Go</button>
</form></div>

  </div>
  <div class="modal-backdrop"></div>
</div>

    </div>
  </div>

    </div>

        <div class="container">
  <div class="site-footer" role="contentinfo">
    <ul class="site-footer-links right">
        <li><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status">Status</a></li>
      <li><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api">API</a></li>
      <li><a href="https://training.github.com" data-ga-click="Footer, go to training, text:training">Training</a></li>
      <li><a href="https://shop.github.com" data-ga-click="Footer, go to shop, text:shop">Shop</a></li>
        <li><a href="https://github.com/blog" data-ga-click="Footer, go to blog, text:blog">Blog</a></li>
        <li><a href="https://github.com/about" data-ga-click="Footer, go to about, text:about">About</a></li>
        <li><a href="https://github.com/pricing" data-ga-click="Footer, go to pricing, text:pricing">Pricing</a></li>

    </ul>

    <a href="https://github.com" aria-label="Homepage">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
</a>
    <ul class="site-footer-links">
      <li>&copy; 2015 <span title="0.10926s from github-fe121-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="https://github.com/site/terms" data-ga-click="Footer, go to terms, text:terms">Terms</a></li>
        <li><a href="https://github.com/site/privacy" data-ga-click="Footer, go to privacy, text:privacy">Privacy</a></li>
        <li><a href="https://github.com/security" data-ga-click="Footer, go to security, text:security">Security</a></li>
        <li><a href="https://github.com/contact" data-ga-click="Footer, go to contact, text:contact">Contact</a></li>
        <li><a href="https://help.github.com" data-ga-click="Footer, go to help, text:help">Help</a></li>
    </ul>
  </div>
</div>



    
    
    

    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <button type="button" class="flash-close js-flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
        <span class="octicon octicon-x"></span>
      </button>
      Something went wrong with that request. Please try again.
    </div>


      <script crossorigin="anonymous" integrity="sha256-t8lSPZPmzQI1oKi30aaR95CdODTNnJyqexZ0ulCLZEw=" src="https://assets-cdn.github.com/assets/frameworks-b7c9523d93e6cd0235a0a8b7d1a691f7909d3834cd9c9caa7b1674ba508b644c.js"></script>
      <script async="async" crossorigin="anonymous" integrity="sha256-C6eaSq1zApeOz5oXqx8DDXhOSRxeMpf/V/r2lSbEKaU=" src="https://assets-cdn.github.com/assets/github-0ba79a4aad7302978ecf9a17ab1f030d784e491c5e3297ff57faf69526c429a5.js"></script>
      
      
      
    <div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner hidden">
      <span class="octicon octicon-alert"></span>
      <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
      <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
    </div>
  </body>
</html>

